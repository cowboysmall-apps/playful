package com.cowboysmall.games.proto;

import com.cowboysmall.playful.assets.AssetLoaderImpl;
import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.projection.Projection;

public class Game {

    public static void main(String... args) {

        Mesh mesh =
                new AssetLoaderImpl()
                        .loadAsset("/playful/playful-spike/src/main/resources/teapot1.obj");

        GamePanel gamePanel = new GamePanel(mesh);

        GameFrame gameFrame = new GameFrame("3D Software Render Demo", gamePanel);
        gameFrame.init();

        GameLoop gameLoop = new GameLoop(gamePanel, 60);
        gameLoop.start();
    }
}
