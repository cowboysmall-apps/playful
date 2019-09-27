package com.cowboysmall.playful.math.translation;

import com.cowboysmall.playful.math.Matrix4D;

public class Translation extends Matrix4D {

    public Translation(double dX, double dY, double dZ) {

        super(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                dX, dY, dZ, 1
        );
    }
}
