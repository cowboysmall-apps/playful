package com.cowboysmall.playful.games.experiment;

import com.cowboysmall.playful.graphics.old.assets.AssetLoaderImpl;
import com.cowboysmall.playful.graphics.old.Mesh;

public class Game {

    public static void main(String... args) {

        Mesh mesh1 =
                new AssetLoaderImpl()
                        .loadAsset("/playful-spike/src/main/resources/objects/cube1.obj");

        GamePanel gamePanel = new GamePanel(mesh1);

        GameFrame gameFrame = new GameFrame("3D Software Render Demo", gamePanel);
        gameFrame.init();

        GameLoop gameLoop = new GameLoop(gamePanel, 60);
        gameLoop.start();
    }
}
