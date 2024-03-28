package com.cowboysmall.games.proto.proto01;

import javax.swing.SwingUtilities;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

public class GameLoop implements Runnable {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private final GamePanel gamePanel;

    private final double frameTime;

    private double delta;
    private long current;


    //_________________________________________________________________________

    public GameLoop(GamePanel gamePanel, long fps) {

        this.gamePanel = gamePanel;
        this.frameTime = 1000000000d / fps;
    }


    //_________________________________________________________________________

    public void start() {

        current = nanoTime();
        executorService.scheduleAtFixedRate(this, (long) frameTime, (long) frameTime, TimeUnit.NANOSECONDS);
    }

    public void stop() {

        executorService.shutdown();
    }


    //_________________________________________________________________________

    @Override
    public void run() {

        long latest = nanoTime();
        delta += (latest - current) / frameTime;
        current = latest;

        while (delta >= 1) {

            gamePanel.update(delta);
            delta--;
        }
        SwingUtilities.invokeLater(gamePanel::repaint);
    }
}
