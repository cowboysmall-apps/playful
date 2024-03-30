package com.cowboysmall.playful.math.v2;


import static java.lang.Math.abs;

public class Operations {

    private static final double EPSILON = 0.000001;

    public static Matrix4 outer(Vector4 v1, Vector4 v2) {

        return new Matrix4(
                v1.x * v2.x, v1.x * v2.y, v1.x * v2.z, 0,
                v1.y * v2.x, v1.y * v2.y, v1.y * v2.z, 0,
                v1.z * v2.x, v1.z * v2.y, v1.z * v2.z, 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________

    public static Vector4 multiply(Matrix4 m, Vector4 v) {

        Vector4 vector4 = new Vector4(
                (m.m[0] * v.x) + (m.m[1] * v.y) + (m.m[2] * v.z) + (m.m[3] * v.w),
                (m.m[4] * v.x) + (m.m[5] * v.y) + (m.m[6] * v.z) + (m.m[7] * v.w),
                (m.m[8] * v.x) + (m.m[9] * v.y) + (m.m[10] * v.z) + (m.m[11] * v.w),
                (m.m[12] * v.x) + (m.m[13] * v.y) + (m.m[14] * v.z) + (m.m[15] * v.w)
        );

//        return vector4;
        return vector4.scale(isZero(vector4.getW()) ? 1.0d / vector4.getW() : 1);
    }

    public static Vector4 multiply(Vector4 v, Matrix4 m) {

        Vector4 vector4 = new Vector4(
                (m.m[0] * v.x) + (m.m[4] * v.y) + (m.m[8] * v.z) + (m.m[12] * v.w),
                (m.m[1] * v.x) + (m.m[5] * v.y) + (m.m[9] * v.z) + (m.m[13] * v.w),
                (m.m[2] * v.x) + (m.m[6] * v.y) + (m.m[10] * v.z) + (m.m[14] * v.w),
                (m.m[3] * v.x) + (m.m[7] * v.y) + (m.m[11] * v.z) + (m.m[15] * v.w)
        );

//        return vector4;
        return vector4.scale(isZero(vector4.getW()) ? 1.0d / vector4.getW() : 1);
    }

    public static Matrix4 multiply(Matrix4 m1, Matrix4 m2) {

        return new Matrix4(
                (m1.m[0] * m2.m[0]) + (m1.m[1] * m2.m[4]) + (m1.m[2] * m2.m[8]) + (m1.m[3] * m2.m[12]),
                (m1.m[0] * m2.m[1]) + (m1.m[1] * m2.m[5]) + (m1.m[2] * m2.m[9]) + (m1.m[3] * m2.m[13]),
                (m1.m[0] * m2.m[2]) + (m1.m[1] * m2.m[6]) + (m1.m[2] * m2.m[10]) + (m1.m[3] * m2.m[14]),
                (m1.m[0] * m2.m[3]) + (m1.m[1] * m2.m[7]) + (m1.m[2] * m2.m[11]) + (m1.m[3] * m2.m[15]),

                (m1.m[4] * m2.m[0]) + (m1.m[5] * m2.m[4]) + (m1.m[6] * m2.m[8]) + (m1.m[7] * m2.m[12]),
                (m1.m[4] * m2.m[1]) + (m1.m[5] * m2.m[5]) + (m1.m[6] * m2.m[9]) + (m1.m[7] * m2.m[13]),
                (m1.m[4] * m2.m[2]) + (m1.m[5] * m2.m[6]) + (m1.m[6] * m2.m[10]) + (m1.m[7] * m2.m[14]),
                (m1.m[4] * m2.m[3]) + (m1.m[5] * m2.m[7]) + (m1.m[6] * m2.m[11]) + (m1.m[7] * m2.m[15]),

                (m1.m[8] * m2.m[0]) + (m1.m[9] * m2.m[4]) + (m1.m[10] * m2.m[8]) + (m1.m[11] * m2.m[12]),
                (m1.m[8] * m2.m[1]) + (m1.m[9] * m2.m[5]) + (m1.m[10] * m2.m[9]) + (m1.m[11] * m2.m[13]),
                (m1.m[8] * m2.m[2]) + (m1.m[9] * m2.m[6]) + (m1.m[10] * m2.m[10]) + (m1.m[11] * m2.m[14]),
                (m1.m[8] * m2.m[3]) + (m1.m[9] * m2.m[7]) + (m1.m[10] * m2.m[11]) + (m1.m[11] * m2.m[15]),

                (m1.m[12] * m2.m[0]) + (m1.m[13] * m2.m[4]) + (m1.m[14] * m2.m[8]) + (m1.m[15] * m2.m[12]),
                (m1.m[12] * m2.m[1]) + (m1.m[13] * m2.m[5]) + (m1.m[14] * m2.m[9]) + (m1.m[15] * m2.m[13]),
                (m1.m[12] * m2.m[2]) + (m1.m[13] * m2.m[6]) + (m1.m[14] * m2.m[10]) + (m1.m[15] * m2.m[14]),
                (m1.m[12] * m2.m[3]) + (m1.m[13] * m2.m[7]) + (m1.m[14] * m2.m[11]) + (m1.m[15] * m2.m[15])
        );
    }


    //_________________________________________________________________________

    public static Quaternion multiply(Quaternion q1, Quaternion q2) {

        return new Quaternion(
                q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z,
                q1.z * q2.y - q1.y * q2.z + q1.x * q2.w + q1.w * q2.x,
                q1.x * q2.z - q1.z * q2.x + q1.y * q2.w + q1.w * q2.y,
                q1.y * q2.x - q1.x * q2.y + q1.z * q2.w + q1.w * q2.z
        );
    }


    //_________________________________________________________________________

    public static boolean isZero(double d) {

        return abs(d) < EPSILON;
    }
}
