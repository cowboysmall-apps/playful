package com.cowboysmall.playful.games.old.engine;

import com.cowboysmall.playful.games.old.engine.graphics.GraphicsEngine;
import com.cowboysmall.playful.games.old.engine.physics.PhysicsEngine;

import static java.lang.System.nanoTime;
import static java.lang.Thread.sleep;

public class GameEngine implements Runnable {

    private PhysicsEngine physicsEngine;
    private GraphicsEngine graphicsEngine;

    private int framesPerSecond;

    private long optimalTicks;
    private long currentTicks;

    private boolean running = true;


    //_________________________________________________________________________

    public GameEngine() {

    }


    //_________________________________________________________________________

    public GameEngine setFramesPerSecond(int framesPerSecond) {

        this.framesPerSecond = framesPerSecond;
        return this;
    }

    public GameEngine setPhysicsEngine(PhysicsEngine physicsEngine) {

        this.physicsEngine = physicsEngine;
        return this;
    }

    public GameEngine setGraphicsEngine(GraphicsEngine graphicsEngine) {

        this.graphicsEngine = graphicsEngine;
        return this;
    }

    public GameEngine initialize() {

        optimalTicks = 1000000000 / framesPerSecond;
        return this;
    }


    //_________________________________________________________________________

    public void start() {

        new Thread(this).start();
    }

    public void stop() {

        running = false;
    }


    //_________________________________________________________________________

    public double getCurrentFPS() {

        return 1000000000d / currentTicks;
    }


    //_________________________________________________________________________

    @Override
    public final void run() {

        while (running) {

            long initialTime = nanoTime();

            update();
            render();
            pause(initialTime);
            record(initialTime);
        }
    }


    //_________________________________________________________________________

    private void update() {

        physicsEngine.update();
    }

    private void render() {

        graphicsEngine.render();
    }


    //_________________________________________________________________________

    private void pause(long initialTime) {

        try {

            long ticks = nanoTime() - initialTime;
            if (optimalTicks - ticks > 0)
                sleep((optimalTicks - ticks) / 1000000);

        } catch (Exception e) {

            //
        }
    }

    private void record(long initialTime) {

        currentTicks = nanoTime() - initialTime;
    }
}
