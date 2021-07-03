package com.cowboysmall.playful.math.lookat;

import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

public class LookAt extends Matrix4D {

    public LookAt(Vector4D eye, Vector4D up) {

        Vector4D w = eye.normalise();
        Vector4D u = up.crossProduct(w).normalise();
        Vector4D v = w.crossProduct(u);

        setValue(0, 0, u.getX());
        setValue(1, 0, v.getX());
        setValue(2, 0, w.getX());

        setValue(0, 1, u.getY());
        setValue(1, 1, v.getY());
        setValue(2, 1, w.getY());

        setValue(0, 2, u.getZ());
        setValue(1, 2, v.getZ());
        setValue(2, 2, w.getZ());

        setValue(0, 3, -u.dotProduct(eye));
        setValue(1, 3, -v.dotProduct(eye));
        setValue(2, 3, -w.dotProduct(eye));
        setValue(3, 3, 1);
    }
}
