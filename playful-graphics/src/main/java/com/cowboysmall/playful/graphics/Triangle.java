package com.cowboysmall.playful.graphics;


import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

import static com.cowboysmall.playful.math.Operations.multiply;
import static java.util.Objects.hash;

public class Triangle {

    private Vector4D a;
    private Vector4D b;
    private Vector4D c;


    //_________________________________________________________________________

    public Triangle(Vector4D a, Vector4D b, Vector4D c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }


    //_________________________________________________________________________

    public Vector4D getA() {
        return a;
    }

    public Vector4D getB() {
        return b;
    }

    public Vector4D getC() {
        return c;
    }


    //_________________________________________________________________________

    public Triangle transform(Matrix4D transformation) {

        return new Triangle(
                multiply(transformation, a),
                multiply(transformation, b),
                multiply(transformation, c)
        );
    }


    //_________________________________________________________________________

    public boolean isNegativeNormal() {

        Vector4D first = b.subtract(a);
        Vector4D second = c.subtract(a);

        return first.cross(second).getZ() < 0;
    }


    //_________________________________________________________________________


    @Override
    public String toString() {

        return "Triangle{a = %s, b = %s, c = %s}".formatted(a, b, c);
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Triangle that)
            return a.equals(that.a)
                    && b.equals(that.b)
                    && c.equals(that.c);

        return false;
    }

    @Override
    public int hashCode() {

        return hash(a, b, c);
    }
}
