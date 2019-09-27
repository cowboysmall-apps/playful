package com.cowboysmall.games;

import com.cowboysmall.games.engine.GameEngine;
import com.cowboysmall.games.engine.graphics.Java2DGraphicsEngine;
import com.cowboysmall.games.engine.physics.SimplePhysicsEngine;


public class Application {

    public static void main(String... args) {

        new GameEngine()
                .setFramesPerSecond(60)
                .setPhysicsEngine(new SimplePhysicsEngine())
                .setGraphicsEngine(new Java2DGraphicsEngine())
                .initialize()
                .start();
    }
}
