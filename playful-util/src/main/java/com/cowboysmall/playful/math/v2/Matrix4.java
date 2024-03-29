package com.cowboysmall.playful.math.v2;


import java.util.Arrays;

public class Matrix4 {

    double[] m;

    public Matrix4(double... m) {

        this.m = m;
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return Arrays.equals(m, ((Matrix4) o).m);
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(m);
    }
}
