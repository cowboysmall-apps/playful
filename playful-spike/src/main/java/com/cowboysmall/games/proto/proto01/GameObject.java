package com.cowboysmall.games.proto.proto01;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.Matrix4D;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private Mesh mesh;

    private Matrix4D transformation = Matrix4D.identity();

    private List<GameObject> children = new ArrayList<>();


    //_________________________________________________________________________

    public GameObject(Mesh mesh) {

        this.mesh = mesh;
    }


    //_________________________________________________________________________

    public boolean add(GameObject gameObject) {

        return children.add(gameObject);
    }
}
