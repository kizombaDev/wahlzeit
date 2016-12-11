package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.exceptions.CoordinateComponentException;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    @Test
    public void propertiesTest() throws CoordinateComponentException {
        CartesianCoordinate oneTwoThreeCoordinate = new CartesianCoordinate(1, 2, 3);

        Assert.assertEquals(1, oneTwoThreeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, oneTwoThreeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, oneTwoThreeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityXTest() throws CoordinateComponentException {
        new CartesianCoordinate(Double.POSITIVE_INFINITY, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityXTest() throws CoordinateComponentException {
        new CartesianCoordinate(Double.NEGATIVE_INFINITY, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberXTest() throws CoordinateComponentException {
        new CartesianCoordinate(Double.NaN, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityYTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, Double.POSITIVE_INFINITY, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityYTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, Double.NEGATIVE_INFINITY, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberYTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, Double.NaN, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberZTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, 2, Double.NaN);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityZTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, 2, Double.POSITIVE_INFINITY);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityZTest() throws CoordinateComponentException {
        new CartesianCoordinate(1, 2, Double.NEGATIVE_INFINITY);
    }
}