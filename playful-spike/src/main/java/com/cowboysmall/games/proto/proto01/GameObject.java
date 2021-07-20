package com.cowboysmall.games.proto.proto01;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private Mesh mesh;

    private Vector4D position = new Vector4D();

    private Matrix4D scale = Matrix4D.identity();

    private Matrix4D rotation = Matrix4D.identity();

//    private List<GameObject> children = new ArrayList<>();


    //_________________________________________________________________________

    public GameObject(Mesh mesh) {

        this.mesh = mesh;
    }


    //_________________________________________________________________________

//    public boolean add(GameObject gameObject) {
//
//        return children.add(gameObject);
//    }
}
