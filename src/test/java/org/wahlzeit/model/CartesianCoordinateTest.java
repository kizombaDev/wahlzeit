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
        CartesianCoordinate oneTwoThreeCoordinate = CartesianCoordinate.create(1, 2, 3);

        Assert.assertEquals(1, oneTwoThreeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, oneTwoThreeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, oneTwoThreeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityXTest() throws CoordinateComponentException {
        CartesianCoordinate.create(Double.POSITIVE_INFINITY, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityXTest() throws CoordinateComponentException {
        CartesianCoordinate.create(Double.NEGATIVE_INFINITY, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberXTest() throws CoordinateComponentException {
        CartesianCoordinate.create(Double.NaN, 2, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityYTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, Double.POSITIVE_INFINITY, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityYTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, Double.NEGATIVE_INFINITY, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberYTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, Double.NaN, 3);
    }

    @Test(expected = CoordinateComponentException.class)
    public void notANumberZTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, 2, Double.NaN);
    }

    @Test(expected = CoordinateComponentException.class)
    public void positiveInfinityZTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, 2, Double.POSITIVE_INFINITY);
    }

    @Test(expected = CoordinateComponentException.class)
    public void negativeInfinityZTest() throws CoordinateComponentException {
        CartesianCoordinate.create(1, 2, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void twoCoordinatesWithTheSameDoublesShouldBeTheSame() throws CoordinateComponentException {
        Assert.assertSame(CartesianCoordinate.create(4, 0, 0), CartesianCoordinate.create(4, 0, 0));
    }

    @Test
    public void twoCoordinatesWithDifferentDoublesShouldNotBeTheSame() throws CoordinateComponentException {
        Assert.assertNotSame(CartesianCoordinate.create(5, 0, 0), CartesianCoordinate.create(4, 0, 0));
    }

    @Test
    public void changeXTest() throws CoordinateComponentException {
        CartesianCoordinate oneTwoThreeCoordinate = CartesianCoordinate.create(1, 2, 3);

        CartesianCoordinate changeCoordinate = oneTwoThreeCoordinate.changeX(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(42, changeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, changeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, changeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test
    public void changeYTest() throws CoordinateComponentException {
        CartesianCoordinate oneTwoThreeCoordinate = CartesianCoordinate.create(1, 2, 3);

        CartesianCoordinate changeCoordinate = oneTwoThreeCoordinate.changeY(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(1, changeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(42, changeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, changeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test
    public void changeZTest() throws CoordinateComponentException {
        CartesianCoordinate oneTwoThreeCoordinate = CartesianCoordinate.create(1, 2, 3);

        CartesianCoordinate changeCoordinate = oneTwoThreeCoordinate.changeZ(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(1, changeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, changeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(42, changeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }
}