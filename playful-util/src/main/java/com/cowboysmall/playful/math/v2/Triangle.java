package com.cowboysmall.playful.math.v2;


import static com.cowboysmall.playful.math.v2.Operations.multiply;
import static java.util.Objects.hash;

public class Triangle {

    private Vector4 a;
    private Vector4 b;
    private Vector4 c;


    //_________________________________________________________________________

    public Triangle(Vector4 a, Vector4 b, Vector4 c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }


    //_________________________________________________________________________

    public Vector4 getA() {
        return a;
    }

    public Vector4 getB() {
        return b;
    }

    public Vector4 getC() {
        return c;
    }


    //_________________________________________________________________________

    public Triangle transform(Matrix4 transformation) {

        return new Triangle(
                multiply(transformation, a),
                multiply(transformation, b),
                multiply(transformation, c)
        );
    }


    //_________________________________________________________________________

    public boolean isNegativeNormal() {

        Vector4 first = b.subtract(a);
        Vector4 second = c.subtract(a);

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
