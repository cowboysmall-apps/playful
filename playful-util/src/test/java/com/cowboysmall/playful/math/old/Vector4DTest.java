package com.cowboysmall.playful.math.old;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Vector4DTest {

    @Test
    public void testVector_DotProduct() {

        Vector4D vector1 = new Vector4D(1, 2, 3);
        Vector4D vector2 = new Vector4D(4, 5, 6);

        assertThat(vector1.dotProduct(vector2), is(32.0d));
    }

    @Test
    public void testVector_CrossProduct() {

        Vector4D vector1 = new Vector4D(1, 2, 3);
        Vector4D vector2 = new Vector4D(4, 5, 6);

        assertThat(vector1.crossProduct(vector2), CoreMatchers.is(new Vector4D(-3, 6, -3)));
    }
}
