package com.cowboysmall.playful.math.old.view;

import com.cowboysmall.playful.math.old.Matrix4D;
import com.cowboysmall.playful.math.old.Vector4D;
import com.cowboysmall.playful.math.old.rotation.Rotation;
import com.cowboysmall.playful.math.old.translation.Translation;

public class View extends Matrix4D {

    public View(double pitch, double yaw, Vector4D position) {

        super(
                new Rotation(pitch, yaw, 0)
                        .preMultiply(new Translation(position.getX(), position.getY(), position.getZ()))
                        .getValues()
        );
    }
}
