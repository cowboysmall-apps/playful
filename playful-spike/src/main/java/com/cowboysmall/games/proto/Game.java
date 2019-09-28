package com.cowboysmall.games.proto;

import com.cowboysmall.playful.assets.AssetLoaderImpl;
import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.projection.Projection;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String... args) {

        Mesh mesh = new AssetLoaderImpl()
                .loadAsset("/playful/playful-spike/src/main/resources/teapot1.obj");
        Projection projection = new Projection(1.3333d, 60d, 0.1d, 1000d);

        GamePanel gamePanel = new GamePanel(projection, mesh);
        new GameFrame("This is a frame", gamePanel).setVisible(true);

        long optimalTime = 1000000000 / 60;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(
                new GameEngine(gamePanel, optimalTime),
                0,
                optimalTime,
                TimeUnit.NANOSECONDS
        );
    }
}
