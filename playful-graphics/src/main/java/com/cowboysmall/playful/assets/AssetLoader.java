package com.cowboysmall.playful.assets;

import com.cowboysmall.playful.graphics.Mesh;

import java.util.List;

public interface AssetLoader {

    List<Mesh> loadAssets();

    Mesh loadAsset(String identifier);
}
