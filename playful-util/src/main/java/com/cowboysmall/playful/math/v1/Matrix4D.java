package com.cowboysmall.playful.math.v1;

import java.util.Arrays;

import static java.lang.String.format;

public class Matrix4D {

    private final double[] values;


    //_________________________________________________________________________

    public Matrix4D(double... values) {

        if (values.length != 16)
            throw new DimensionException("4X4 matrix should be initialized with 16 values");

        this.values = values;
    }

    public Matrix4D() {

        this(new double[16]);
    }


    //_________________________________________________________________________

    public double[] getValues() {

        return values;
    }


    //_________________________________________________________________________

    public double getValue(int i, int j) {

        if (i < 0 || i > 3)
            throw new DimensionException(format("%d out of range: 0 <= i <= 3", i));

        if (j < 0 || j > 3)
            throw new DimensionException(format("%d out of range: 0 <= j <= 3", j));

        return values[(i * 4) + j];
    }

    public void setValue(int i, int j, double value) {

        if (i < 0 || i > 3)
            throw new DimensionException(format("%d out of range: 0 <= i <= 3", i));

        if (j < 0 || j > 3)
            throw new DimensionException(format("%d out of range: 0 <= j <= 3", j));

        values[(i * 4) + j] = value;
    }


    //_________________________________________________________________________

    public Vector4D postMultiply(Vector4D vector) {

        double[] vectorValues = vector.getValues();

        Vector4D vector4D = new Vector4D(
                values[0] * vectorValues[0] + values[4] * vectorValues[1] + values[8] * vectorValues[2] + values[12] * vectorValues[3],
                values[1] * vectorValues[0] + values[5] * vectorValues[1] + values[9] * vectorValues[2] + values[13] * vectorValues[3],
                values[2] * vectorValues[0] + values[6] * vectorValues[1] + values[10] * vectorValues[2] + values[14] * vectorValues[3],
                values[3] * vectorValues[0] + values[7] * vectorValues[1] + values[11] * vectorValues[2] + values[15] * vectorValues[3]
        );

        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }

    public Vector4D preMultiply(Vector4D vector) {

        double[] vectorValues = vector.getValues();

        Vector4D vector4D = new Vector4D(
                values[0] * vectorValues[0] + values[1] * vectorValues[1] + values[2] * vectorValues[2] + values[3] * vectorValues[3],
                values[4] * vectorValues[0] + values[5] * vectorValues[1] + values[6] * vectorValues[2] + values[7] * vectorValues[3],
                values[8] * vectorValues[0] + values[9] * vectorValues[1] + values[10] * vectorValues[2] + values[11] * vectorValues[3],
                values[12] * vectorValues[0] + values[13] * vectorValues[1] + values[14] * vectorValues[2] + values[15] * vectorValues[3]
        );

        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }

    public Matrix4D multiply(double scalar) {

        return new Matrix4D(
                Arrays.stream(values)
                        .map(value -> value * scalar)
                        .toArray()
        );
    }

    public Matrix4D add(Matrix4D other) {

        return new Matrix4D(
                values[0] + other.values[0], values[1] + other.values[1], values[2] + other.values[2], values[3] + other.values[3],
                values[4] + other.values[4], values[5] + other.values[5], values[6] + other.values[6], values[7] + other.values[7],
                values[8] + other.values[8], values[9] + other.values[9], values[10] + other.values[10], values[11] + other.values[11],
                values[12] + other.values[12], values[13] + other.values[13], values[14] + other.values[14], values[15] + other.values[15]
        );
    }


    //_________________________________________________________________________

    public Matrix4D postMultiply(Matrix4D matrix) {

        double[] matrixValues = matrix.getValues();

        return new Matrix4D(
                values[0] * matrixValues[0] + values[4] * matrixValues[1] + values[8] * matrixValues[2] + values[12] * matrixValues[3],
                values[1] * matrixValues[0] + values[5] * matrixValues[1] + values[9] * matrixValues[2] + values[13] * matrixValues[3],
                values[2] * matrixValues[0] + values[6] * matrixValues[1] + values[10] * matrixValues[2] + values[14] * matrixValues[3],
                values[3] * matrixValues[0] + values[7] * matrixValues[1] + values[11] * matrixValues[2] + values[15] * matrixValues[3],

                values[0] * matrixValues[4] + values[4] * matrixValues[5] + values[8] * matrixValues[6] + values[12] * matrixValues[7],
                values[1] * matrixValues[4] + values[5] * matrixValues[5] + values[9] * matrixValues[6] + values[13] * matrixValues[7],
                values[2] * matrixValues[4] + values[6] * matrixValues[5] + values[10] * matrixValues[6] + values[14] * matrixValues[7],
                values[3] * matrixValues[4] + values[7] * matrixValues[5] + values[11] * matrixValues[6] + values[15] * matrixValues[7],

                values[0] * matrixValues[8] + values[4] * matrixValues[9] + values[8] * matrixValues[10] + values[12] * matrixValues[11],
                values[1] * matrixValues[8] + values[5] * matrixValues[9] + values[9] * matrixValues[10] + values[13] * matrixValues[11],
                values[2] * matrixValues[8] + values[6] * matrixValues[9] + values[10] * matrixValues[10] + values[14] * matrixValues[11],
                values[3] * matrixValues[8] + values[7] * matrixValues[9] + values[11] * matrixValues[10] + values[15] * matrixValues[11],

                values[0] * matrixValues[12] + values[4] * matrixValues[13] + values[8] * matrixValues[14] + values[12] * matrixValues[15],
                values[1] * matrixValues[12] + values[5] * matrixValues[13] + values[9] * matrixValues[14] + values[13] * matrixValues[15],
                values[2] * matrixValues[12] + values[6] * matrixValues[13] + values[10] * matrixValues[14] + values[14] * matrixValues[15],
                values[3] * matrixValues[12] + values[7] * matrixValues[13] + values[11] * matrixValues[14] + values[15] * matrixValues[15]
        );
    }

    public Matrix4D preMultiply(Matrix4D matrix) {

        double[] matrixValues = matrix.getValues();

        return new Matrix4D(
                values[0] * matrixValues[0] + values[1] * matrixValues[4] + values[2] * matrixValues[8] + values[3] * matrixValues[12],
                values[0] * matrixValues[1] + values[1] * matrixValues[5] + values[2] * matrixValues[9] + values[3] * matrixValues[13],
                values[0] * matrixValues[2] + values[1] * matrixValues[6] + values[2] * matrixValues[10] + values[3] * matrixValues[14],
                values[0] * matrixValues[3] + values[1] * matrixValues[7] + values[2] * matrixValues[11] + values[3] * matrixValues[15],

                values[4] * matrixValues[0] + values[5] * matrixValues[4] + values[6] * matrixValues[8] + values[7] * matrixValues[12],
                values[4] * matrixValues[1] + values[5] * matrixValues[5] + values[6] * matrixValues[9] + values[7] * matrixValues[13],
                values[4] * matrixValues[2] + values[5] * matrixValues[6] + values[6] * matrixValues[10] + values[7] * matrixValues[14],
                values[4] * matrixValues[3] + values[5] * matrixValues[7] + values[6] * matrixValues[11] + values[7] * matrixValues[15],

                values[8] * matrixValues[0] + values[9] * matrixValues[4] + values[10] * matrixValues[8] + values[11] * matrixValues[12],
                values[8] * matrixValues[1] + values[9] * matrixValues[5] + values[10] * matrixValues[9] + values[11] * matrixValues[13],
                values[8] * matrixValues[2] + values[9] * matrixValues[6] + values[10] * matrixValues[10] + values[11] * matrixValues[14],
                values[8] * matrixValues[3] + values[9] * matrixValues[7] + values[10] * matrixValues[11] + values[11] * matrixValues[15],

                values[12] * matrixValues[0] + values[13] * matrixValues[4] + values[14] * matrixValues[8] + values[15] * matrixValues[12],
                values[12] * matrixValues[1] + values[13] * matrixValues[5] + values[14] * matrixValues[9] + values[15] * matrixValues[13],
                values[12] * matrixValues[2] + values[13] * matrixValues[6] + values[14] * matrixValues[10] + values[15] * matrixValues[14],
                values[12] * matrixValues[3] + values[13] * matrixValues[7] + values[14] * matrixValues[11] + values[15] * matrixValues[15]
        );
    }


    //_________________________________________________________________________

    public Matrix4D transpose() {

        return new Matrix4D(
                values[0], values[4], values[8], values[12],
                values[1], values[5], values[9], values[13],
                values[2], values[6], values[10], values[14],
                values[3], values[7], values[11], values[15]
        );
    }


    //_________________________________________________________________________

    public static Matrix4D identity() {

        return new Matrix4D(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    //_________________________________________________________________________


    @Override
    public String toString() {

        return "Matrix4D{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (other instanceof Matrix4D) {

            Matrix4D matrix4D = (Matrix4D) other;
            return Arrays.equals(values, matrix4D.values);
        }

        return false;
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(values);
    }
}
