package com.cowboysmall.playful.games.experiment;

import com.cowboysmall.playful.graphics.old.Mesh;
import com.cowboysmall.playful.math.old.Matrix4D;
import com.cowboysmall.playful.math.old.Vector4D;

public class GameObject {

    private Mesh mesh;

    private Vector4D position = new Vector4D();

    private Matrix4D scale = Matrix4D.identity();

    private Matrix4D rotation = Matrix4D.identity();


    //_________________________________________________________________________

    public GameObject(Mesh mesh) {

        this.mesh = mesh;
    }
}
