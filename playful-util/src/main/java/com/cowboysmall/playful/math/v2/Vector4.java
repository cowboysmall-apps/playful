package com.cowboysmall.playful.math.v2;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Vector4 {

    float x, y, z, w;

    public Vector4(float x, float y, float z, float w) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(float x, float y, float z) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }


    //_________________________________________________________________________

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
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

    public float dot(Vector4 v) {

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

    public Vector4 scale(float factor) {

        return new Vector4(factor * x, factor * y, factor * z);
    }

    public float squareLength() {

        return dot(this);
    }

    public float length() {

        return (float) sqrt(squareLength());
    }

    public Vector4 normalise() {

        return scale(1.0f / length());
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector4 vector4 = (Vector4) o;
        return Float.compare(x, vector4.x) == 0
                && Float.compare(y, vector4.y) == 0
                && Float.compare(z, vector4.z) == 0
                && Float.compare(w, vector4.w) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z, w);
    }
}
