package com.cowboysmall.playful.graphics.old.assets;

import com.cowboysmall.playful.graphics.old.Mesh;

import java.util.List;

public interface AssetLoader {

    List<Mesh> loadAssets();

    Mesh loadAsset(String identifier);
}
