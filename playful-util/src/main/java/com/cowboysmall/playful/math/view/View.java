package com.cowboysmall.playful.math.view;

import com.cowboysmall.playful.math.Matrix4D;
import com.cowboysmall.playful.math.Vector4D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class View extends Matrix4D {

    public View(double pitch, double yaw, Vector4D position) {

//        Vector4D x = new Vector4D(1, 0, 0);
//        Vector4D y = new Vector4D(0, 1, 0);
//        Vector4D z = new Vector4D(0, 0, 1);

        Vector4D x = new Vector4D(
                cos(toRadians(yaw)),
                0,
                -sin(toRadians(yaw))
        );

        Vector4D y = new Vector4D(
                sin(toRadians(yaw)) * sin(toRadians(pitch)),
                cos(toRadians(pitch)),
                cos(toRadians(yaw)) * sin(toRadians(pitch))
        );

        Vector4D z = new Vector4D(
                sin(toRadians(yaw)) * cos(toRadians(pitch)),
                -sin(toRadians(pitch)),
                cos(toRadians(yaw)) * cos(toRadians(pitch))
        );

        setValue(0, 0, x.getX());
        setValue(0, 1, y.getX());
        setValue(0, 2, z.getX());

        setValue(1, 0, x.getY());
        setValue(1, 1, y.getY());
        setValue(1, 2, z.getY());

        setValue(2, 0, x.getZ());
        setValue(2, 1, y.getZ());
        setValue(2, 2, z.getZ());


//        setValue(0, 0, x.getX());
//        setValue(0, 1, x.getY());
//        setValue(0, 2, x.getZ());
//
//        setValue(1, 0, y.getX());
//        setValue(1, 1, y.getY());
//        setValue(1, 2, y.getZ());
//
//        setValue(2, 0, z.getX());
//        setValue(2, 1, z.getY());
//        setValue(2, 2, z.getZ());

//        setValue(0, 0, x.getX());
//        setValue(0, 1, y.getX());
//        setValue(0, 2, z.getX());
//
//        setValue(1, 0, x.getY());
//        setValue(1, 1, y.getY());
//        setValue(1, 2, z.getY());
//
//        setValue(2, 0, x.getZ());
//        setValue(2, 1, y.getZ());
//        setValue(2, 2, z.getZ());

        setValue(3, 0, -x.dotProduct(position));
        setValue(3, 1, -y.dotProduct(position));
        setValue(3, 2, -z.dotProduct(position));
        setValue(3, 3, 1);

//        setValue(3, 0, -(x.getX() * position.getX() + y.getX() * position.getY() + z.getX() * position.getZ()));
//        setValue(3, 1, -(x.getY() * position.getX() + y.getY() * position.getY() + z.getY() * position.getZ()));
//        setValue(3, 2, -(x.getZ() * position.getX() + y.getZ() * position.getY() + z.getZ() * position.getZ()));
//        setValue(3, 3, 1);
    }
}
