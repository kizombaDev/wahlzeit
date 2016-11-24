package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    private CartesianCoordinate oneTwoThreeCoordinate = new CartesianCoordinate(1, 2, 3);
    private CartesianCoordinate fourFiveSixCoordinate = new CartesianCoordinate(4, 5, 6);
    private CartesianCoordinate zeroZeroZeroCoordinate = new CartesianCoordinate(0, 0, 0);


    @Test
    public void propertiesTest() {
        Assert.assertEquals(1, oneTwoThreeCoordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, oneTwoThreeCoordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, oneTwoThreeCoordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceTestWithCartesianCoordinatesTest() {

        Assert.assertEquals(5.196152, oneTwoThreeCoordinate.getDistance(fourFiveSixCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceTestWithCartesianAndSphericCoordinatesTest() {
        SphericCoordinate coordinateTwo = new SphericCoordinate(46.861562380329, 51.34019174591, 8.7749643873921);
        Assert.assertEquals(5.196152, oneTwoThreeCoordinate.getDistance(coordinateTwo), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceBetweenTwoPointsWithTheSameLocation() {
        Assert.assertEquals(0, oneTwoThreeCoordinate.getDistance(oneTwoThreeCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceWithZeroPoint() {

        CartesianCoordinate secondPoint = new CartesianCoordinate(1, 0, 0);

        Assert.assertEquals(1, zeroZeroZeroCoordinate.getDistance(secondPoint), DOUBLE_TEST_DELTA);
    }

    @Test
    public void isEqualWithNullCoordinate() {
        Assert.assertFalse(zeroZeroZeroCoordinate.isEqual(null));
    }

    @Test
    public void isEqualWithTwoEqualCoordinates() {
        CartesianCoordinate first = new CartesianCoordinate(1, 2, 3);
        Assert.assertTrue(first.isEqual(oneTwoThreeCoordinate));
    }

    @Test
    public void isEqualWithTwoDifferentCoordinates() {
        Assert.assertFalse(oneTwoThreeCoordinate.isEqual(zeroZeroZeroCoordinate));
    }

    @Test
    public void isEqualWithTheSameCoordinate() {
        Assert.assertTrue(oneTwoThreeCoordinate.isEqual(oneTwoThreeCoordinate));
    }


}