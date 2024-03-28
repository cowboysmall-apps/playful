package com.cowboysmall.games.proto.proto04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

public abstract class Game {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


    private long fps;

    private long currentTime;

    private double frameTime;

    private double delta;


    //_________________________________________________________________________

    public Game(long fps) {

        this.fps = fps;
        this.frameTime = 1_000_000_000 / (double) fps;
    }


    //_________________________________________________________________________

    public void start() {

        init();
        startGameLoop();
    }

    public void stop() {

        stopGameLoop();
        destroy();
    }


    //_________________________________________________________________________

    private void gameLoop() {

        long latestTime = nanoTime();
        delta += (latestTime - currentTime) / frameTime;
        currentTime = latestTime;

        while (delta >= 1) {

            update(delta);
            delta--;
        }

        render();
    }


    //_________________________________________________________________________

    private void startGameLoop() {

        currentTime = nanoTime();
        executorService.scheduleAtFixedRate(this::gameLoop, (long) frameTime, (long) frameTime, TimeUnit.NANOSECONDS);
    }

    private void stopGameLoop() {

        executorService.shutdown();
        try {

            if (!executorService.awaitTermination((long) frameTime, TimeUnit.NANOSECONDS))
                executorService.shutdownNow();

        } catch (InterruptedException e) {

            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    //_________________________________________________________________________

    protected void init() {
    }

    protected abstract void update(double delta);

    protected abstract void render();

    protected void destroy() {
    }
}
