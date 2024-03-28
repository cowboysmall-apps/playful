package com.cowboysmall.games.proto.proto01;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

public class GameLoop implements Runnable {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private final GamePanel gamePanel;

    private final double frameTime;

    private boolean running;


    //_________________________________________________________________________

    public GameLoop(GamePanel gamePanel, long fps) {

        this.gamePanel = gamePanel;
        this.frameTime = 1000000000d / fps;
    }


    //_________________________________________________________________________

    public void start() {

        running = true;
//        new Thread(this).start();
        executorService.scheduleAtFixedRate(this, 0, (long) this.frameTime, TimeUnit.MICROSECONDS);
    }

    public void stop() {

        running = false;
    }

//    public boolean isRunning() {
//
//        return running;
//    }


    //_________________________________________________________________________

    @Override
    public void run() {

//        long start = nanoTime();
//        long lag = 0;
//
//        while (isRunning()) {
//
//            long current = nanoTime();
//            lag += current - start;
//            start = current;
//
//            while (lag >= frameTime) {
//
//                gamePanel.update(lag / frameTime);
//                lag -= frameTime;
//            }
//
//            gamePanel.repaint();
//        }

        double delta = 0;

        long current = nanoTime();
        while (running) {

            long latest = nanoTime();
            delta += (latest - current) / frameTime;
            current = latest;

            while (delta >= 1) {

                gamePanel.update(delta);
                SwingUtilities.invokeLater(gamePanel::repaint);
                delta--;
            }
        }
    }


    //_________________________________________________________________________

//    private void pause(long time) {
//
//        try {
//
//            double delta = frameTime - nanoTimeFromNow(time);
//            if (delta > 0)
//                sleep((long) delta / 1000000);
//
//        } catch (Exception e) {
//
//            throw new GameException(e);
//        }
//    }
//
//    private long nanoTimeFromNow(long time) {
//
//        return nanoTime() - time;
//    }
}
