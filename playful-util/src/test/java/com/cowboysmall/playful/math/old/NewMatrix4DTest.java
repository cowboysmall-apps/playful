package com.cowboysmall.playful.math.old;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewMatrix4DTest {

    @Test
    public void testMatrix4D_PreMultiply_Identity() {

        NewMatrix4D matrix4D = new NewMatrix4D(new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}});
        NewVector4D vector4D = new NewVector4D(4, 5, 6);

        assertThat(matrix4D.multiply(vector4D), CoreMatchers.is(new NewVector4D(4, 5, 6)));
    }

    @Test
    public void testMatrix4D_PostMultiply_Identity() {

        NewMatrix4D matrix4D = new NewMatrix4D(new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}});
        NewVector4D vector4D = new NewVector4D(4, 5, 6);

        assertThat(matrix4D.multiply(vector4D), CoreMatchers.is(new NewVector4D(4, 5, 6)));
    }

    @Test
    public void testMatrix4D_PreMultiply() {

        NewMatrix4D matrix4D = new NewMatrix4D(new double[][]{{1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 1}});
        NewVector4D vector4D = new NewVector4D(2, 4, 6);

        assertThat(matrix4D.multiply(vector4D), CoreMatchers.is(new NewVector4D(28, 64, 100)));
    }

    @Test
    public void testMatrix4D_PostMultiply() {

        NewMatrix4D matrix4D = new NewMatrix4D(new double[][]{{1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 1}});
        NewVector4D vector4D = new NewVector4D(2, 4, 6);

        assertThat(vector4D.multiply(matrix4D), CoreMatchers.is(new NewVector4D(60, 72, 84)));
    }

    @Test
    public void testMatrix4D_Transpose() {

        NewMatrix4D matrix4D = new NewMatrix4D(new double[][]{{1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 1}});

        assertThat(matrix4D.transpose(), CoreMatchers.is(new NewMatrix4D(new double[][]{{1, 4, 7, 0}, {2, 5, 8, 0}, {3, 6, 9, 0}, {0, 0, 0, 1}})));
    }
}
