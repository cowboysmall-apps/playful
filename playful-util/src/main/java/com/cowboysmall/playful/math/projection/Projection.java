package com.cowboysmall.playful.math.projection;

import com.cowboysmall.playful.math.Matrix4D;

import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

public class Projection extends Matrix4D {

    public Projection(double aspectRatio, double fieldOfView, double near, double far) {

        super();

        double zoom = 1.0d / tan(toRadians(fieldOfView / 2.0d));
        setValue(0, 0, zoom);
        setValue(1, 1, aspectRatio * zoom);
        setValue(2, 2, (far + near) / (far - near));
        setValue(2, 3, 1);
        setValue(3, 2, -(2 * far * near) / (far - near));
    }
}
