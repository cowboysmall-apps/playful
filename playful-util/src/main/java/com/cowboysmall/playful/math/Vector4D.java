package com.cowboysmall.playful.math;


import static java.lang.Double.compare;
import static java.lang.Math.sqrt;
import static java.util.Objects.hash;

public class Vector4D {

    double x, y, z, w;

    public Vector4D(double x, double y, double z, double w) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4D(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }


    //_________________________________________________________________________

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getW() {
        return w;
    }


    //_________________________________________________________________________

    public Vector4D add(Vector4D v) {

        return new Vector4D(x + v.x, y + v.y, z + v.z);
    }

    public Vector4D subtract(Vector4D v) {

        return new Vector4D(x - v.x, y - v.y, z - v.z);
    }


    //_________________________________________________________________________

    public double dot(Vector4D v) {

        return (x * v.x) + (y * v.y) + (z * v.z);
    }

    public Vector4D cross(Vector4D v) {

        return new Vector4D(
                (y * v.z) - (z * v.y),
                (z * v.x) - (x * v.z),
                (x * v.y) - (y * v.x)
        );
    }


    //_________________________________________________________________________

    public Vector4D scale(double factor) {

        return new Vector4D(factor * x, factor * y, factor * z);
    }

    public double squareLength() {

        return dot(this);
    }

    public double length() {

        return (float) sqrt(squareLength());
    }

    public Vector4D normalise() {

        return scale(1.0d / length());
    }


    //_________________________________________________________________________


    @Override
    public String toString() {

        return "Vector4{x = %s, y = %s, z = %s, w = %s}".formatted(x, y, z, w);
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Vector4D that)
            return compare(x, that.x) == 0
                    && compare(y, that.y) == 0
                    && compare(z, that.z) == 0
                    && compare(w, that.w) == 0;

        return false;
    }

    @Override
    public int hashCode() {

        return hash(x, y, z, w);
    }
}
