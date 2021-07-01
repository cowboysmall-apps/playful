package com.cowboysmall.games.proto.proto01;

import static java.lang.System.nanoTime;
import static java.lang.Thread.sleep;

public class GameLoop implements Runnable {

    private final GamePanel gamePanel;
    private final long frameTime;

    private boolean running;


    //_________________________________________________________________________

    public GameLoop(GamePanel gamePanel, long fps) {

        this.gamePanel = gamePanel;
        this.frameTime = 1000000000 / fps;
    }


    //_________________________________________________________________________

    public void start() {

        running = true;
        new Thread(this).start();
    }

    public void stop() {

        running = false;
    }

    public boolean isRunning() {

        return running;
    }


    //_________________________________________________________________________

    @Override
    public void run() {

        long start = nanoTime();
        long lag = 0;

        while (isRunning()) {

            long current = nanoTime();
            lag += current - start;
            start = current;

            while (lag >= frameTime) {

                gamePanel.update(lag / frameTime);
                lag -= frameTime;
            }

            gamePanel.repaint();
            pause(current);
        }
    }


    //_________________________________________________________________________

    private void pause(long time) {

        try {

            long delta = frameTime - nanoTimeFromNow(time);
            if (delta > 0)
                sleep(delta / 1000000);

        } catch (Exception e) {

            throw new GameException(e);
        }
    }

    private long nanoTimeFromNow(long time) {

        return nanoTime() - time;
    }
}
