package com.cowboysmall.playful.math.v1.rotation;

import com.cowboysmall.playful.math.v1.Matrix4D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RotationX extends Matrix4D {

    public RotationX(double theta) {

        super(
                1, 0, 0, 0,
                0, cos(theta), sin(theta), 0,
                0, -sin(theta), cos(theta), 0,
                0, 0, 0, 1
        );
    }
}
