package com.cowboysmall.playful.math.old.projection;

import com.cowboysmall.playful.math.old.Matrix4D;

import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

public class Projection extends Matrix4D {

    public Projection(double aspectRatio, double fieldOfView, double near, double far) {

        super();

        double zoom = 1.0d / tan(toRadians(fieldOfView / 2.0d));

//        setValue(0, 0, zoom);
//        setValue(1, 1, aspectRatio * zoom);
//        setValue(2, 2, (far + near) / (far - near));
//        setValue(2, 3, 1);
//        setValue(3, 2, -(2 * far * near) / (far - near));

        setValue(0, 0, zoom / aspectRatio);
        setValue(1, 1, zoom);
        setValue(2, 2, (near + far) / (near - far));
        setValue(2, 3, -1);
        setValue(3, 2, (2 * near * far) / (near - far));

//        setValue(0, 0, zoom / aspectRatio);
//        setValue(1, 1, zoom);
//        setValue(2, 2, (near + far) / (near - far));
//        setValue(2, 3, (2 * near * far) / (near - far));
//        setValue(3, 2, -1);

//        setValue(0, 0, zoom);
//        setValue(1, 1, aspectRatio * zoom);
//        setValue(2, 2, far / (far - near));
//        setValue(2, 3, 1);
//        setValue(3, 2, -(far * near) / (far - near));
    }
}
