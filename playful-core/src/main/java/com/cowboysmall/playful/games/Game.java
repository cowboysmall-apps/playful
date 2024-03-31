package com.cowboysmall.playful.games;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

public abstract class Game implements KeyListener, ComponentListener {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


    private Renderer renderer;


    private final long fps;

    private final double frameTime;


    private long currentTime;

    private double delta;


    //_________________________________________________________________________


    public Game(Renderer renderer, long fps) {

        this.renderer = renderer;
        this.fps = fps;
        this.frameTime = 1_000_000_000 / (double) fps;
    }

    public Game(long fps) {

        this(new Renderer(), fps);
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

        getRenderer().render();
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

    protected void destroy() {
    }


    //_________________________________________________________________________

    public final void initRenderer(Dimension size) {

        renderer.setPreferredSize(size);
        renderer.init();
    }


    //_________________________________________________________________________

    public Renderer getRenderer() {

        return renderer;
    }

    public void setRenderer(Renderer renderer) {

        this.renderer = renderer;
    }


    //_________________________________________________________________________

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    //_________________________________________________________________________

    @Override
    public void componentResized(ComponentEvent e) {

        initRenderer(((JFrame) e.getSource()).getSize());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
