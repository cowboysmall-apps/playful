package com.cowboysmall.playful.math.old.rotation;

import com.cowboysmall.playful.math.old.Matrix4D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RotationY extends Matrix4D {

    public RotationY(double theta) {

        super(
                cos(theta), 0, -sin(theta), 0,
                0, 1, 0, 0,
                sin(theta), 0, cos(theta), 0,
                0, 0, 0, 1
        );
    }
}
