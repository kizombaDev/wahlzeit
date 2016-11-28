package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    @Test
    public void propertiesTest() {
        CartesianCoordinate oneTwoThreeCoordinate = new CartesianCoordinate(1, 2, 3);

        Assert.assertEquals(1, oneTwoThreeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, oneTwoThreeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, oneTwoThreeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }
}