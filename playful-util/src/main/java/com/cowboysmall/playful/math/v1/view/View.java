package com.cowboysmall.playful.math.v1.view;

import com.cowboysmall.playful.math.v1.Matrix4D;
import com.cowboysmall.playful.math.v1.Vector4D;
import com.cowboysmall.playful.math.v1.rotation.Rotation;
import com.cowboysmall.playful.math.v1.translation.Translation;

public class View extends Matrix4D {

    public View(double pitch, double yaw, Vector4D position) {

        super(
                new Rotation(pitch, yaw, 0)
                        .preMultiply(new Translation(position.getX(), position.getY(), position.getZ()))
                        .getValues()
        );
    }
}
