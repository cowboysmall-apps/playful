package com.cowboysmall.playful.math;


public class Operations {

    public static Matrix4D outer(Vector4D v1, Vector4D v2) {

        return new Matrix4D(
                v1.x * v2.x, v1.x * v2.y, v1.x * v2.z, 0,
                v1.y * v2.x, v1.y * v2.y, v1.y * v2.z, 0,
                v1.z * v2.x, v1.z * v2.y, v1.z * v2.z, 0,
                0, 0, 0, 1
        );
    }


    //_________________________________________________________________________

    public static Vector4D multiply(Matrix4D m, Vector4D v) {

        Vector4D vector4D = new Vector4D(
                (m.m[0] * v.x) + (m.m[1] * v.y) + (m.m[2] * v.z) + (m.m[3] * v.w),
                (m.m[4] * v.x) + (m.m[5] * v.y) + (m.m[6] * v.z) + (m.m[7] * v.w),
                (m.m[8] * v.x) + (m.m[9] * v.y) + (m.m[10] * v.z) + (m.m[11] * v.w),
                (m.m[12] * v.x) + (m.m[13] * v.y) + (m.m[14] * v.z) + (m.m[15] * v.w)
        );

        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }

    public static Vector4D multiply(Vector4D v, Matrix4D m) {

        Vector4D vector4D = new Vector4D(
                (m.m[0] * v.x) + (m.m[4] * v.y) + (m.m[8] * v.z) + (m.m[12] * v.w),
                (m.m[1] * v.x) + (m.m[5] * v.y) + (m.m[9] * v.z) + (m.m[13] * v.w),
                (m.m[2] * v.x) + (m.m[6] * v.y) + (m.m[10] * v.z) + (m.m[14] * v.w),
                (m.m[3] * v.x) + (m.m[7] * v.y) + (m.m[11] * v.z) + (m.m[15] * v.w)
        );

        return vector4D.scale(vector4D.getW() != 0.0d ? 1.0d / vector4D.getW() : 1);
    }


    //_________________________________________________________________________

    public static Matrix4D multiply(Matrix4D m1, Matrix4D m2) {

        return new Matrix4D(
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

    public static Matrix4D multiply(Matrix4D m1, Matrix4D m2, Matrix4D m3) {

        return multiply(multiply(m1, m2), m3);
    }

    public static Matrix4D multiply(Matrix4D m1, Matrix4D m2, Matrix4D m3, Matrix4D m4) {

        return multiply(multiply(multiply(m1, m2), m3), m4);
    }

    public static Matrix4D multiply(Matrix4D m1, Matrix4D m2, Matrix4D m3, Matrix4D m4, Matrix4D m5) {

        return multiply(multiply(multiply(multiply(m1, m2), m3), m4), m5);
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
}
