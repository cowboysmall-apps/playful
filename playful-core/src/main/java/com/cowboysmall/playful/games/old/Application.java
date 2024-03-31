package com.cowboysmall.playful.games.old;

import com.cowboysmall.playful.games.old.engine.GameEngine;
import com.cowboysmall.playful.games.old.engine.graphics.Java2DGraphicsEngine;
import com.cowboysmall.playful.games.old.engine.physics.SimplePhysicsEngine;


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
