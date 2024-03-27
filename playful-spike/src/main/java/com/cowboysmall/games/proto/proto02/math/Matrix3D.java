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

        return new Vector3D(
                elements[getIndex(0, col)],
                elements[getIndex(1, col)],
                elements[getIndex(2, col)],
                elements[getIndex(3, col)]
        );
    }

    public Vector3D getRow(int row) {

        return new Vector3D(
                elements[getIndex(row, 0)],
                elements[getIndex(row, 1)],
                elements[getIndex(row, 2)],
                elements[getIndex(row, 3)]
        );
    }


    //_________________________________________________________________________

    public Matrix3D multiply(Matrix3D matrix) {

        Vector3D row1 = getRow(0);
        Vector3D row2 = getRow(1);
        Vector3D row3 = getRow(2);
        Vector3D row4 = getRow(3);

        Vector3D col1 = matrix.getColumn(0);
        Vector3D col2 = matrix.getColumn(1);
        Vector3D col3 = matrix.getColumn(2);
        Vector3D col4 = matrix.getColumn(3);

        return new Matrix3D(new float[]{
                row1.dot(col1), row1.dot(col2), row1.dot(col3), row1.dot(col4),
                row2.dot(col1), row2.dot(col2), row2.dot(col3), row2.dot(col4),
                row3.dot(col1), row3.dot(col2), row3.dot(col3), row3.dot(col4),
                row4.dot(col1), row4.dot(col2), row4.dot(col3), row4.dot(col4)
        });
    }

    public Vector3D multiply(Vector3D vector) {

        return new Vector3D(
                getRow(0).dot(vector),
                getRow(1).dot(vector),
                getRow(2).dot(vector),
                getRow(3).dot(vector)
        );
    }

    public Vector3D preMultiply(Vector3D vector) {

        return new Vector3D(
                getColumn(0).dot(vector),
                getColumn(1).dot(vector),
                getColumn(2).dot(vector),
                getColumn(3).dot(vector)
        );
    }


    //_________________________________________________________________________

    private static int getIndex(int row, int col) {

        return (row * 4) + col;
    }
}
