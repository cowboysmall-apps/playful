package com.cowboysmall.playful.assets;

import com.cowboysmall.playful.graphics.Mesh;

import java.util.Collections;
import java.util.List;

public class AssetLoaderImpl implements AssetLoader {

    @Override
    public List<Mesh> loadAssets() {

        return Collections.singletonList(loadAsset("identifier"));
    }

    @Override
    public Mesh loadAsset(String identifier) {

        return new ObjectFileLoader().loadFromObjectFile(identifier);
    }
}
