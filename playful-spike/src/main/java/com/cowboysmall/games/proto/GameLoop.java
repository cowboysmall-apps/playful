package com.cowboysmall.games.proto;

import static java.lang.System.nanoTime;
import static java.lang.Thread.sleep;

public class GameLoop implements Runnable {

    private GamePanel gamePanel;

    private long optimalTime;

    private boolean running;


    //_________________________________________________________________________

    public GameLoop(GamePanel gamePanel, long fps) {

        this.gamePanel = gamePanel;
        this.optimalTime = 1000000000 / fps;
    }


    //_________________________________________________________________________

    public void start() {

        new Thread(this).start();
    }

    public void stop() {

        running = false;
    }


    //_________________________________________________________________________

    @Override
    public void run() {

        long actualFPS = 0;
        long marker = nanoTime();

        running = true;

        while (running) {

            long startTime = nanoTime();

            gamePanel.update(1.0d);
            gamePanel.repaint();

            pause(startTime);

            actualFPS++;
            if (ticksFrom(marker) >= 1000000000) {

                System.out.printf(">>> fps: %d%n", actualFPS);
                actualFPS = 0;
                marker = nanoTime();
            }
        }
    }


    //_________________________________________________________________________

    private void pause(long time) {

        try {

            if (optimalTime - ticksFrom(time) > 0)
                sleep((optimalTime - ticksFrom(time)) / 1000000);

        } catch (Exception e) {

            //
        }
    }

    private long ticksFrom(long time) {

        return nanoTime() - time;
    }
}
