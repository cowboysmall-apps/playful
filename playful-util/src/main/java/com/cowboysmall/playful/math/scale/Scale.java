package com.cowboysmall.playful.math.scale;

import com.cowboysmall.playful.math.Matrix4D;

public class Scale extends Matrix4D {

    public Scale(double sX, double sY, double sZ) {

        super(
                sX, 0, 0, 0,
                0, sY, 0, 0,
                0, 0, sZ, 0,
                0, 0, 0, 1
        );
    }
}
