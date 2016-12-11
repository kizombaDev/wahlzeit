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

    @Test(expected = IllegalArgumentException.class)
    public void positiveInfinityXTest() {
        new CartesianCoordinate(Double.POSITIVE_INFINITY, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInfinityXTest() {
        new CartesianCoordinate(Double.NEGATIVE_INFINITY, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notANumberXTest() {
        new CartesianCoordinate(Double.NaN, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void positiveInfinityYTest() {
        new CartesianCoordinate(1, Double.POSITIVE_INFINITY, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInfinityYTest() {
        new CartesianCoordinate(1, Double.NEGATIVE_INFINITY, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notANumberYTest() {
        new CartesianCoordinate(1, Double.NaN, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notANumberZTest() {
        new CartesianCoordinate(1, 2, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void positiveInfinityZTest() {
        new CartesianCoordinate(1, 2, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInfinityZTest() {
        new CartesianCoordinate(1, 2, Double.NEGATIVE_INFINITY);
    }
}