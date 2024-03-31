package com.cowboysmall.playful.math;


import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

public class Transformations {

    public Matrix4D eye() {

        return new Matrix4D(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D translate(double dX, double dY, double dZ) {

        return new Matrix4D(
                1, 0, 0, dX,
                0, 1, 0, dY,
                0, 0, 1, dZ,
                0, 0, 0, 1
        );
    }

    public static Matrix4D rotateX(double theta) {

        return new Matrix4D(
                1, 0, 0, 0,
                0, cos(theta), -sin(theta), 0,
                0, sin(theta), cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D rotateY(double theta) {

        return new Matrix4D(
                cos(theta), 0, sin(theta), 0,
                0, 1, 0, 0,
                -sin(theta), 0, cos(theta), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D rotateZ(double theta) {

        return new Matrix4D(
                cos(theta), -sin(theta), 0, 0,
                sin(theta), cos(theta), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D scale(double factor) {

        return new Matrix4D(
                factor, 0, 0, 0,
                0, factor, 0, 0,
                0, 0, factor, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D scale(double factorX, double factorY, double factorZ) {

        return new Matrix4D(
                factorX, 0, 0, 0,
                0, factorY, 0, 0,
                0, 0, factorZ, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4D projection(double aspectRatio, double fieldOfView, double near, double far) {

        double zoom = 1.0d / tan(toRadians(fieldOfView / 2.0d));

        return new Matrix4D(
                zoom / aspectRatio, 0, 0, 0,
                0, zoom, 0, 0,
                0, 0, (near + far) / (near - far), (2 * near * far) / (near - far),
                0, 0, -1, 0
        );
    }
}
