package com.cowboysmall.games.proto.proto02.math;

public class Matrix3D {

    private final float[] elements;

    public Matrix3D(float[] elements) {

        this.elements = elements;
    }


    //_________________________________________________________________________

    public float getElement(int row, int col) {

        return elements[getIndex(row, col)];
    }

    public Vector3D getColumn(int col) {

        return new Vector3D(elements[getIndex(0, col)], elements[getIndex(1, col)], elements[getIndex(2, col)], elements[getIndex(3, col)]);
    }

    public Vector3D getRow(int row) {

        return new Vector3D(elements[getIndex(row, 0)], elements[getIndex(row, 1)], elements[getIndex(row, 2)], elements[getIndex(row, 3)]);
    }


    //_________________________________________________________________________

    public Matrix3D multiply(Matrix3D matrix) {

        return new Matrix3D(new float[]{
                getRow(0).dot(matrix.getColumn(0)), getRow(0).dot(matrix.getColumn(1)), getRow(0).dot(matrix.getColumn(2)), getRow(0).dot(matrix.getColumn(3)),
                getRow(1).dot(matrix.getColumn(0)), getRow(1).dot(matrix.getColumn(1)), getRow(1).dot(matrix.getColumn(2)), getRow(1).dot(matrix.getColumn(3)),
                getRow(2).dot(matrix.getColumn(0)), getRow(2).dot(matrix.getColumn(1)), getRow(2).dot(matrix.getColumn(2)), getRow(2).dot(matrix.getColumn(3)),
                getRow(3).dot(matrix.getColumn(0)), getRow(3).dot(matrix.getColumn(1)), getRow(3).dot(matrix.getColumn(2)), getRow(3).dot(matrix.getColumn(3))
        });
    }

    public Vector3D multiply(Vector3D vector) {

        return new Vector3D(getRow(0).dot(vector), getRow(1).dot(vector), getRow(2).dot(vector), getRow(3).dot(vector));
    }

    public Vector3D preMultiply(Vector3D vector) {

        return new Vector3D(getColumn(0).dot(vector), getColumn(1).dot(vector), getColumn(2).dot(vector), getColumn(3).dot(vector));
    }


    //_________________________________________________________________________

    private static int getIndex(int row, int col) {

        return (row * 4) + col;
    }
}
