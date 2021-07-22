package com.cowboysmall.playful.math;

import java.util.Arrays;

import static java.lang.Math.sqrt;
import static java.lang.String.format;

public class NewVector4D {

    private final double[] values;


    //_________________________________________________________________________

    public NewVector4D(double x, double y, double z) {

        this(x, y, z, 1);
    }

    public NewVector4D(double... values) {

        if (values.length != 4)
            throw new DimensionException(format("4 != %d", values.length));

        this.values = values;
    }

    public NewVector4D() {

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

    public NewVector4D add(NewVector4D other) {

        return new NewVector4D(values[0] + other.values[0], values[1] + other.values[1], values[2] + other.values[2]);
    }

    public NewVector4D subtract(NewVector4D other) {

        return new NewVector4D(values[0] - other.values[0], values[1] - other.values[1], values[2] - other.values[2]);
    }


    //_________________________________________________________________________

    public NewVector4D multiply(NewMatrix4D matrix4D) {

        NewVector4D vector4D =  matrix4D.transpose().multiply(this);
//        Vector4D vector4D = matrix4D.postMultiply(this);
        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }


    //_________________________________________________________________________

    public NewVector4D translate(double dX, double dY, double dZ) {

        return new NewVector4D(values[0] + dX, values[1] + dY, values[2] + dZ);
    }

    public NewVector4D translateX(double dX) {

        return new NewVector4D(values[0] + dX, values[1], values[2]);
    }

    public NewVector4D translateY(double dY) {

        return new NewVector4D(values[0], values[1] + dY, values[2]);
    }

    public NewVector4D translateZ(double dZ) {

        return new NewVector4D(values[0], values[1], values[2] + dZ);
    }


    //_________________________________________________________________________

    public NewVector4D scale(double factorX, double factorY, double factorZ) {

        return new NewVector4D(factorX * values[0], factorY * values[1], factorZ * values[2]);
    }

    public NewVector4D scale(double factor) {

        return new NewVector4D(factor * values[0], factor * values[1], factor * values[2]);
    }

    public NewVector4D scaleX(double factor) {

        return new NewVector4D(factor * values[0], values[1], values[2]);
    }

    public NewVector4D scaleY(double factor) {

        return new NewVector4D(values[0], factor * values[1], values[2]);
    }

    public NewVector4D scaleZ(double factor) {

        return new NewVector4D(values[0], values[1], factor * values[2]);
    }


    //_________________________________________________________________________

    public double dotProduct(NewVector4D other) {

        return (values[0] * other.values[0]) + (values[1] * other.values[1]) + (values[2] * other.values[2]);
    }

    public NewVector4D crossProduct(NewVector4D other) {

        return new NewVector4D(
                (values[1] * other.values[2]) - (values[2] * other.values[1]),
                (values[2] * other.values[0]) - (values[0] * other.values[2]),
                (values[0] * other.values[1]) - (values[1] * other.values[0])
        );
    }

    public NewMatrix4D outerProduct(NewVector4D other) {

        return new NewMatrix4D(
                new double[][]{
                        {values[0] * other.values[0], values[0] * other.values[1], values[0] * other.values[2], 0},
                        {values[1] * other.values[0], values[1] * other.values[1], values[1] * other.values[2], 0},
                        {values[2] * other.values[0], values[2] * other.values[1], values[2] * other.values[2], 0},
                        {0, 0, 0, 1}
                }
        );

//        return new Matrix4D(
//                new double[][]{
//                        {values[0] * other.values[0], values[0] * other.values[1], values[0] * other.values[2], values[0] * other.values[3]},
//                        {values[1] * other.values[0], values[1] * other.values[1], values[1] * other.values[2], values[1] * other.values[3]},
//                        {values[2] * other.values[0], values[2] * other.values[1], values[2] * other.values[2], values[2] * other.values[3]},
//                        {values[3] * other.values[0], values[3] * other.values[1], values[3] * other.values[2], values[3] * other.values[3]}
//                }
//        );
    }


    //_________________________________________________________________________

    public double length() {

        return sqrt(dotProduct(this));
    }

    public NewVector4D normalise() {

        return scale(1.0d / length());
    }


    //_________________________________________________________________________


    @Override
    public String toString() {

        return Arrays.toString(values);
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof NewVector4D) {

            NewVector4D vector4D = (NewVector4D) other;
            return Arrays.equals(values, vector4D.values);
        }

        return false;
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(values);
    }
}
