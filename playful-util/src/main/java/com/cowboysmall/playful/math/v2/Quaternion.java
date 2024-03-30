package com.cowboysmall.playful.math.v2;


import java.util.Objects;

import static java.lang.Math.sqrt;

public class Quaternion {

    double w, x, y, z;

    public Quaternion(double w, double x, double y, double z) {

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

    public double dot(Quaternion q) {

        return (w * q.w) + (x * q.x) + (y * q.y) + (z * q.z);
    }


    //_________________________________________________________________________

    public Quaternion scale(double factor) {

        return new Quaternion(factor * w, factor * x, factor * y, factor * z);
    }

    public double squareLength() {

        return dot(this);
    }

    public double length() {

        return sqrt(squareLength());
    }

    public Quaternion normalise() {

        return scale(1.0d / length());
    }


    //_________________________________________________________________________

    public Vector4 rotate(Vector4 v) {

        double vm = 2.0d * (x * v.x + y * v.y + z * v.z);
        double cm = 2.0d * w;
        double pm = cm * w - 1.0d;

        return new Vector4(
                pm * v.x + vm * x + cm * (y * v.z - z * v.y),
                pm * v.y + vm * y + cm * (z * v.x - x * v.z),
                pm * v.z + vm * z + cm * (x * v.y - y * v.x)
        );
    }


    //_________________________________________________________________________

    public Matrix4 toMatrix() {

        double s = 2.0d / squareLength();

        double sx = s * x;
        double sy = s * y;
        double sz = s * z;

        double a1 = 1.0d - y * sy - z * sz;
        double a2 = x * sy - w * sz;
        double a3 = x * sz + w * sy;

        double b1 = x * sy + w * sz;
        double b2 = 1.0d - x * sx - z * sz;
        double b3 = y * sx - w * sx;

        double c1 = x * sz - w * sy;
        double c2 = y * sz + w * sx;
        double c3 = 1.0d - x * sx - y * sy;

        return new Matrix4(
                a1, a2, a3, 0,
                b1, b2, b3, 0,
                c1, c2, c3, 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________


    @Override
    public String toString() {

        return "Quaternion{w = %s, x = %s, y = %s, z = %s}".formatted(w, x, y, z);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o instanceof Quaternion that)
            return Double.compare(w, that.w) == 0
                    && Double.compare(x, that.x) == 0
                    && Double.compare(y, that.y) == 0
                    && Double.compare(z, that.z) == 0;

        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(w, x, y, z);
    }
}
