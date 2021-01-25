package com.cowboysmall.games.proto.proto02;

import com.cowboysmall.playful.assets.AssetLoaderImpl;
import com.cowboysmall.playful.graphics.Mesh;

public class Game {

    public static void main(String... args) {

        Mesh mesh =
                new AssetLoaderImpl()
                        .loadAsset("/playful-spike/src/main/resources/objects/cube1.obj");

        new GameFrame("Game Frame");
    }
}
