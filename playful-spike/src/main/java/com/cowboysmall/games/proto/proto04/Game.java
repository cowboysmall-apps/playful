package com.cowboysmall.games.proto.proto04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

public abstract class Game implements Runnable {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private boolean running;

    private final long framesPerSecond;


    //_________________________________________________________________________

    public Game(long framesPerSecond) {

        this.framesPerSecond = framesPerSecond;
    }


    //_________________________________________________________________________

    public void start() {

        running = true;
        executorService.scheduleAtFixedRate(this, 0, 10, TimeUnit.MICROSECONDS);
    }

    public void stop() {

        running = false;
    }


    //_________________________________________________________________________

    @Override
    public void run() {

        double frameTime = 1000000000d / framesPerSecond;
        double delta = 0;

        long current = nanoTime();
        while (running) {

            long latest = nanoTime();
            delta += (latest - current) / frameTime;
            current = latest;

            while (delta >= 1) {

                update(delta);
                render();
                delta--;
            }
        }
    }


    //_________________________________________________________________________

    protected abstract void update(double delta);

    protected abstract void render();
}
