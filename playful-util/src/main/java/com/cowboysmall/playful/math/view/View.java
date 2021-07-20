package com.cowboysmall.playful.math.view;

import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;
import com.cowboysmall.playful.math.rotation.Rotation;
import com.cowboysmall.playful.math.translation.Translation;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class View extends Matrix4D {

    public View(double pitch, double yaw, Vector4D position) {

        super(
                new Rotation(pitch, yaw, 0)
                        .preMultiply(new Translation(position.getX(), position.getY(), position.getZ()))
                        .getValues()
        );
    }
}
