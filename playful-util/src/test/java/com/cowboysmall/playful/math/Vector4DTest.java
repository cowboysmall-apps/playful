package com.cowboysmall.playful.math;

import com.cowboysmall.playful.math.Vector4D;
import org.junit.Test;

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

        assertThat(vector1.crossProduct(vector2), is(new Vector4D(-3, 6, -3)));
    }
}
