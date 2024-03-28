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
}
