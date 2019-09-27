package com.cowboysmall.games.proto;

import javax.swing.SwingUtilities;

public class GameEngine implements Runnable {

    private GamePanel gamePanel;

    private long optimalTime;
    private long framesPerSecond;
    private long elapsedTime;

    private long startTime;
    private double delta;


    //_________________________________________________________________________

    public GameEngine(GamePanel gamePanel, long optimalTime) {

        this.gamePanel = gamePanel;
        this.optimalTime = optimalTime;
    }


    //_________________________________________________________________________

    @Override
    public void run() {

        SwingUtilities.invokeLater(() -> {

            if (startTime == 0L)
                startTime = System.nanoTime();

            gamePanel.update(delta);
            gamePanel.repaint();

            long endTime = System.nanoTime();
            long tick = endTime - startTime;

            delta = ((double) tick) / optimalTime;

//            System.out.println(">>> time: " + delta);
            startTime = endTime;

            elapsedTime += tick;
            framesPerSecond++;

            if (elapsedTime >= 1000000000) {

                System.out.println(">>>  fps: " + framesPerSecond);
                framesPerSecond = 0;
                elapsedTime = 0;
            }
        });
    }
}
