package com.cowboysmall.playful.math.v2;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transformations {

    public Matrix4 eye() {

        return new Matrix4(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 translate(float dx, float dy, float dz) {

        return new Matrix4(
                1, 0, 0, dx,
                0, 1, 0, dy,
                0, 0, 1, dz,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateX(float theta) {

        return new Matrix4(
                1, 0, 0, 0,
                0, (float) cos(theta), (float) -sin(theta), 0,
                0, (float) sin(theta), (float) cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateY(float theta) {

        return new Matrix4(
                (float) cos(theta), 0, (float) sin(theta), 0,
                0, 1, 0, 0,
                (float) -sin(theta), 0, (float) cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateZ(float theta) {

        return new Matrix4(
                (float) cos(theta), (float) -sin(theta), 0, 0,
                (float) sin(theta), (float) cos(theta), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 scale(float a, float b, float c) {

        return new Matrix4(
                a, 0, 0, 0,
                0, b, 0, 0,
                0, 0, c, 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________

    public static Matrix4 rotate(Quaternion q) {

        float s = 2.0f / q.squareLength();

        float sx = s * q.x;
        float sy = s * q.y;
        float sz = s * q.z;

        float a1 = 1.0f - q.y * sy - q.z * sz;
        float a2 = q.x * sy - q.w * sz;
        float a3 = q.x * sz + q.w * sy;

        float b1 = q.x * sy + q.w * sz;
        float b2 = 1.0f - q.x * sx - q.z * sz;
        float b3 = q.y * sx - q.w * sx;

        float c1 = q.x * sz - q.w * sy;
        float c2 = q.y * sz + q.w * sx;
        float c3 = 1.0f - q.x * sx - q.y * sy;

        return new Matrix4(
                a1, a2, a3, 0,
                b1, b2, b3, 0,
                c1, c2, c3, 0,
                0, 0, 0, 1
        );
    }
}
