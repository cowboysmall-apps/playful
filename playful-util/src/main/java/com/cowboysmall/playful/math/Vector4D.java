package com.cowboysmall.playful.math;

import static java.lang.Double.compare;
import static java.lang.String.format;
import static java.util.Objects.hash;

public class Vector4D {

    private final double x;
    private final double y;
    private final double z;
    private final double w;


    //_________________________________________________________________________

    public Vector4D(double x, double y, double z, double w) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4D(double x, double y, double z) {

        this(x, y, z, 1);
    }

    public Vector4D(double... values) {

        if (values.length != 4)
            throw new DimensionException(format("4 != %d", values.length));

        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
        this.w = values[3];
    }

    public Vector4D() {

        this(0, 0, 0, 1);
    }

    //_________________________________________________________________________

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getW() {
        return w;
    }


    //_________________________________________________________________________

    public double[] getValues() {

        return new double[]{x, y, z, w};
    }


    //_________________________________________________________________________

    public Vector4D add(Vector4D other) {

        return new Vector4D(x + other.x, y + other.y, z + other.z);
    }

    public Vector4D subtract(Vector4D other) {

        return new Vector4D(x - other.x, y - other.y, z - other.z);
    }


    //_________________________________________________________________________

    public Vector4D multiply(Matrix4D matrix4D) {

        Vector4D vector4D = matrix4D.postMultiply(this);
        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }


    //_________________________________________________________________________

    public Vector4D translate(double dX, double dY, double dZ) {

        return new Vector4D(x + dX, y + dY, z + dZ);
    }

    public Vector4D translateX(double dX) {

        return new Vector4D(x + dX, y, z);
    }

    public Vector4D translateY(double dY) {

        return new Vector4D(x, y + dY, z);
    }

    public Vector4D translateZ(double dZ) {

        return new Vector4D(x, y, z + dZ);
    }


    //_________________________________________________________________________

    public Vector4D scale(double factorX, double factorY, double factorZ) {

        return new Vector4D(factorX * x, factorY * y, factorZ * z);
    }

    public Vector4D scale(double factor) {

        return new Vector4D(factor * x, factor * y, factor * z);
    }

    public Vector4D scaleX(double factor) {

        return new Vector4D(factor * x, y, z);
    }

    public Vector4D scaleY(double factor) {

        return new Vector4D(x, factor * y, z);
    }

    public Vector4D scaleZ(double factor) {

        return new Vector4D(x, y, factor * z);
    }


    //_________________________________________________________________________

    public double dotProduct(Vector4D other) {

        return (x * other.x) + (y * other.y) + (z * other.z);
    }

    public Vector4D crossProduct(Vector4D other) {

        return new Vector4D(
                (y * other.z) - (z * other.y),
                (z * other.x) - (x * other.z),
                (x * other.y) - (y * other.x)
        );
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Vector4D) {

            Vector4D vector4D = (Vector4D) other;
            return compare(x, vector4D.x) == 0 &&
                    compare(y, vector4D.y) == 0 &&
                    compare(z, vector4D.z) == 0 &&
                    compare(w, vector4D.w) == 0;
        }

        return false;
    }

    @Override
    public int hashCode() {

        return hash(x, y, z, w);
    }
}
