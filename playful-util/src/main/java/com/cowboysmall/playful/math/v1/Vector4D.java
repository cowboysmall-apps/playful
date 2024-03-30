package com.cowboysmall.playful.math.v1;

import java.util.Arrays;

import static java.lang.Math.sqrt;
import static java.lang.String.format;

public class Vector4D {

    private final double[] values;


    //_________________________________________________________________________

    public Vector4D(double x, double y, double z) {

        this(x, y, z, 1);
    }

    public Vector4D(double... values) {

        if (values.length != 4)
            throw new DimensionException(format("4 != %d", values.length));

        this.values = values;
    }

    public Vector4D() {

        this(0, 0, 0, 1);
    }

    //_________________________________________________________________________

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

    public double getZ() {
        return values[2];
    }

    public double getW() {
        return values[3];
    }


    //_________________________________________________________________________

    public double[] getValues() {

        return values;
    }


    //_________________________________________________________________________

    public Vector4D add(Vector4D other) {

        return new Vector4D(values[0] + other.values[0], values[1] + other.values[1], values[2] + other.values[2]);
    }

    public Vector4D subtract(Vector4D other) {

        return new Vector4D(values[0] - other.values[0], values[1] - other.values[1], values[2] - other.values[2]);
    }


    //_________________________________________________________________________

    public Vector4D multiply(Matrix4D matrix4D) {

        return matrix4D.postMultiply(this);
    }


    //_________________________________________________________________________

    public Vector4D translate(double dX, double dY, double dZ) {

        return new Vector4D(values[0] + dX, values[1] + dY, values[2] + dZ);
    }

    public Vector4D translateX(double dX) {

        return new Vector4D(values[0] + dX, values[1], values[2]);
    }

    public Vector4D translateY(double dY) {

        return new Vector4D(values[0], values[1] + dY, values[2]);
    }

    public Vector4D translateZ(double dZ) {

        return new Vector4D(values[0], values[1], values[2] + dZ);
    }


    //_________________________________________________________________________

    public Vector4D scale(double factorX, double factorY, double factorZ) {

        return new Vector4D(factorX * values[0], factorY * values[1], factorZ * values[2]);
    }

    public Vector4D scale(double factor) {

        return new Vector4D(factor * values[0], factor * values[1], factor * values[2]);
    }

    public Vector4D scaleX(double factor) {

        return new Vector4D(factor * values[0], values[1], values[2]);
    }

    public Vector4D scaleY(double factor) {

        return new Vector4D(values[0], factor * values[1], values[2]);
    }

    public Vector4D scaleZ(double factor) {

        return new Vector4D(values[0], values[1], factor * values[2]);
    }


    //_________________________________________________________________________

    public double dotProduct(Vector4D other) {

        return (values[0] * other.values[0]) + (values[1] * other.values[1]) + (values[2] * other.values[2]);
    }

    public Vector4D crossProduct(Vector4D other) {

        return new Vector4D(
                (values[1] * other.values[2]) - (values[2] * other.values[1]),
                (values[2] * other.values[0]) - (values[0] * other.values[2]),
                (values[0] * other.values[1]) - (values[1] * other.values[0])
        );
    }

    public Matrix4D outerProduct(Vector4D other) {

        return new Matrix4D(
                values[0] * other.values[0], values[0] * other.values[1], values[0] * other.values[2], 0,
                values[1] * other.values[0], values[1] * other.values[1], values[1] * other.values[2], 0,
                values[2] * other.values[0], values[2] * other.values[1], values[2] * other.values[2], 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________

    public double length() {

        return sqrt(dotProduct(this));
    }

    public Vector4D normalise() {

        return scale(1.0d / length());
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Vector4D) {

            Vector4D vector4D = (Vector4D) other;
            return Arrays.equals(values, vector4D.values);
        }

        return false;
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(values);
    }
}
