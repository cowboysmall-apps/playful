package com.cowboysmall.playful.graphics;

import com.cowboysmall.playful.math.v1.Matrix4D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.hash;

public class Mesh {

    private List<Triangle> triangles;


    //_________________________________________________________________________

    public Mesh(List<Triangle> triangles) {

        this.triangles = triangles;
    }

    public Mesh() {

        this(new ArrayList<>());
    }


    //_________________________________________________________________________

    public List<Triangle> getTriangles() {

        return triangles;
    }


    //_________________________________________________________________________

    public Mesh transform(Matrix4D transformation) {

        return new Mesh(
                triangles.stream()
                        .map(triangle -> triangle.transform(transformation))
                        .collect(Collectors.toList())
        );
    }

//    public Mesh project(Matrix4D projection) {
//
//        return new Mesh(
//                triangles.stream()
//                        .filter(Triangle::isNegativeNormal)
//                        .map(triangle -> triangle.transform(projection))
//                        .collect(Collectors.toList())
//        );
//    }


    //_________________________________________________________________________

    public Stream<Triangle> stream() {

        return triangles.stream();
    }

    public boolean add(Triangle triangle) {

        return triangles.add(triangle);
    }

    public void clear() {

        triangles.clear();
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Mesh) {

            Mesh mesh = (Mesh) other;
            return triangles.equals(mesh.triangles);
        }

        return false;
    }

    @Override
    public int hashCode() {

        return hash(triangles);
    }
}
