package com.cowboysmall.playful.math.v1.rotation;

import com.cowboysmall.playful.math.v1.Matrix4D;

public class Rotation extends Matrix4D {

    public Rotation(double theta_x, double theta_y, double theta_z) {

        super(
                new RotationX(theta_x)
                        .preMultiply(new RotationY(theta_y))
                        .preMultiply(new RotationZ(theta_z))
                        .getValues()
        );
    }
}
