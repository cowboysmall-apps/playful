package com.cowboysmall.playful.math.v2;


import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

public class Transformations {

    public Matrix4 eye() {

        return new Matrix4(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 translate(double dX, double dY, double dZ) {

        return new Matrix4(
                1, 0, 0, dX,
                0, 1, 0, dY,
                0, 0, 1, dZ,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateX(double theta) {

        return new Matrix4(
                1, 0, 0, 0,
                0, cos(theta), -sin(theta), 0,
                0, sin(theta), cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateY(double theta) {

        return new Matrix4(
                cos(theta), 0, sin(theta), 0,
                0, 1, 0, 0,
                -sin(theta), 0, cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 rotateZ(double theta) {

        return new Matrix4(
                cos(theta), -sin(theta), 0, 0,
                sin(theta), cos(theta), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 scale(double factor) {

        return new Matrix4(
                factor, 0, 0, 0,
                0, factor, 0, 0,
                0, 0, factor, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 scale(double factorX, double factorY, double factorZ) {

        return new Matrix4(
                factorX, 0, 0, 0,
                0, factorY, 0, 0,
                0, 0, factorZ, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4 projection(double aspectRatio, double fieldOfView, double near, double far) {

        double zoom = 1.0d / tan(toRadians(fieldOfView / 2.0d));

        return new Matrix4(
                zoom / aspectRatio, 0, 0, 0,
                0, zoom, 0, 0,
                0, 0, (near + far) / (near - far), (2 * near * far) / (near - far),
                0, 0, -1, 0
        );
    }
}
