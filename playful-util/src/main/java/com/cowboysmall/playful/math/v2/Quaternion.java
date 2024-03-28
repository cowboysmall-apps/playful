package com.cowboysmall.playful.math.v2;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Quaternion {

    float w, x, y, z;

    public Quaternion(float w, float x, float y, float z) {

        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //_________________________________________________________________________

    public Quaternion add(Quaternion q) {

        return new Quaternion(w + q.w, x + q.x, y + q.y, z + q.z);
    }

    public Quaternion subtract(Quaternion q) {

        return new Quaternion(w + q.w, x - q.x, y - q.y, z - q.z);
    }


    //_________________________________________________________________________

    public float dot(Quaternion q) {

        return (w * q.w) + (x * q.x) + (y * q.y) + (z * q.z);
    }


    //_________________________________________________________________________

    public Quaternion scale(float factor) {

        return new Quaternion(factor * w, factor * x, factor * y, factor * z);
    }

    public float squareLength() {

        return dot(this);
    }

    public float length() {

        return (float) sqrt(squareLength());
    }

    public Quaternion normalise() {

        return scale(1.0f / length());
    }


    //_________________________________________________________________________

    public Vector4 rotate(Vector4 v) {

        float vm = 2.0f * (x * v.x + y * v.y + z * v.z);
        float cm = 2.0f * w;
        float pm = cm * w - 1.0f;

        return new Vector4(
                pm * v.x + vm * x + cm * (y * v.z - z * v.y),
                pm * v.y + vm * y + cm * (z * v.x - x * v.z),
                pm * v.z + vm * z + cm * (x * v.y - y * v.x)
        );
    }


    //_________________________________________________________________________

    public Matrix4 toMatrix() {

        float s = 2.0f / squareLength();

        float sx = s * x;
        float sy = s * y;
        float sz = s * z;

        float a1 = 1.0f - y * sy - z * sz;
        float a2 = x * sy - w * sz;
        float a3 = x * sz + w * sy;

        float b1 = x * sy + w * sz;
        float b2 = 1.0f - x * sx - z * sz;
        float b3 = y * sx - w * sx;

        float c1 = x * sz - w * sy;
        float c2 = y * sz + w * sx;
        float c3 = 1.0f - x * sx - y * sy;

        return new Matrix4(
                a1, a2, a3, 0,
                b1, b2, b3, 0,
                c1, c2, c3, 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quaternion that = (Quaternion) o;
        return Float.compare(w, that.w) == 0
                && Float.compare(x, that.x) == 0
                && Float.compare(y, that.y) == 0
                && Float.compare(z, that.z) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(w, x, y, z);
    }
}
