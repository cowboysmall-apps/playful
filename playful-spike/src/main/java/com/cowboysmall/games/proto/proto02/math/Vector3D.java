package com.cowboysmall.games.proto.proto02.math;

public class Vector3D {

    private float x, y, z, w;

    public Vector3D(float x, float y, float z, float w) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector3D(float x, float y, float z) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }


    //_________________________________________________________________________

    public float dot(Vector3D vector) {

        return (x * vector.x) + (y * vector.y) + (z * vector.z) + (w * vector.w);
    }

    public Vector3D multiply(Matrix3D matrix) {

        return matrix.preMultiply(this);
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

    public float getW() {
        return w;
    }
}
