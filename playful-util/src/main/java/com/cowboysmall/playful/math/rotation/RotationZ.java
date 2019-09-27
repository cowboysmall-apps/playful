package com.cowboysmall.playful.math.rotation;

import com.cowboysmall.playful.math.Matrix4D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RotationZ extends Matrix4D {

    public RotationZ(double theta) {

        super(
                cos(theta), sin(theta), 0, 0,
                -sin(theta), cos(theta), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }
}
