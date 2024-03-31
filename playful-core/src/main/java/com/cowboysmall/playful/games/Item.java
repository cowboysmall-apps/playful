package com.cowboysmall.playful.games;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

public class Item {

    private Mesh mesh;

    private Vector4D position;

    private Matrix4D scale;

    private Matrix4D rotation;


    //_________________________________________________________________________

    public Item(Mesh mesh, Vector4D position, Matrix4D scale, Matrix4D rotation) {

        this.mesh = mesh;
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }
}
