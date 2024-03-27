package com.cowboysmall.playful.math.v2;

import java.util.Arrays;

public class Matrix4 {

    float[] m;

    public Matrix4(float... m) {

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
