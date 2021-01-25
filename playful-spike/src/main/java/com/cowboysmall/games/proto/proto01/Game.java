package com.cowboysmall.games.proto.proto01;

import com.cowboysmall.playful.assets.AssetLoaderImpl;
import com.cowboysmall.playful.graphics.Mesh;

public class Game {

    public static void main(String... args) {

//        Mesh mesh1 =
//                new AssetLoaderImpl()
//                        .loadAsset("/playful-spike/src/main/resources/objects/cube1.obj");
        Mesh mesh2 =
                new AssetLoaderImpl()
                        .loadAsset("/playful-spike/src/main/resources/objects/teapot2.obj");

//        GamePanel gamePanel = new GamePanel(mesh1, mesh2);

        GamePanel gamePanel = new GamePanel(mesh2);

        GameFrame gameFrame = new GameFrame("3D Software Render Demo", gamePanel);
        gameFrame.init();

        GameLoop gameLoop = new GameLoop(gamePanel, 60);
        gameLoop.start();
    }
}
