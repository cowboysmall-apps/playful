package com.cowboysmall.playful.math.v1.translation;

import com.cowboysmall.playful.math.v1.Matrix4D;

public class Translation extends Matrix4D {

    public Translation(double dX, double dY, double dZ) {

        super(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                dX, dY, dZ, 1

//                1, 0, 0, dX,
//                0, 1, 0, dY,
//                0, 0, 1, dZ,
//                0, 0, 0, 1
        );
    }
}
