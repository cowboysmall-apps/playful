package com.cowboysmall.playful.math;


import java.util.Arrays;

public class Matrix4D {

    double[] m;

    public Matrix4D(double... m) {

        this.m = m;
    }


    //_________________________________________________________________________

    @Override
    public String toString() {

        return "Matrix4{m = %s}".formatted(Arrays.toString(m));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o instanceof Matrix4D that)
            return Arrays.equals(m, that.m);

        return false;
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(m);
    }
}
