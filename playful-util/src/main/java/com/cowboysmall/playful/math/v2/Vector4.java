package com.cowboysmall.playful.math.v2;


import java.util.Objects;

import static java.lang.Math.sqrt;

public class Vector4 {

    double x, y, z, w;

    public Vector4(double x, double y, double z, double w) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(double x, double y, double z) {

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


    //_________________________________________________________________________

    public Vector4 add(Vector4 v) {

        return new Vector4(x + v.x, y + v.y, z + v.z);
    }

    public Vector4 subtract(Vector4 v) {

        return new Vector4(x - v.x, y - v.y, z - v.z);
    }


    //_________________________________________________________________________

    public double dot(Vector4 v) {

        return (x * v.x) + (y * v.y) + (z * v.z);
    }

    public Vector4 cross(Vector4 v) {

        return new Vector4(
                (y * v.z) - (z * v.y),
                (z * v.x) - (x * v.z),
                (x * v.y) - (y * v.x)
        );
    }


    //_________________________________________________________________________

    public Vector4 scale(double factor) {

        return new Vector4(factor * x, factor * y, factor * z);
    }

    public double squareLength() {

        return dot(this);
    }

    public double length() {

        return (float) sqrt(squareLength());
    }

    public Vector4 normalise() {

        return scale(1.0d / length());
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector4 vector4 = (Vector4) o;
        return Double.compare(x, vector4.x) == 0
                && Double.compare(y, vector4.y) == 0
                && Double.compare(z, vector4.z) == 0
                && Double.compare(w, vector4.w) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z, w);
    }
}
