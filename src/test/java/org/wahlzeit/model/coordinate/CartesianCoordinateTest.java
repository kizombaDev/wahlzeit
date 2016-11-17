package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    @Test
    public void propertiesTest()
    {
        CartesianCoordinate coordinate = new CartesianCoordinate(1,2,3);
        Assert.assertEquals(1, coordinate.getX(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(2, coordinate.getY(), DOUBLE_TEST_DELTA);
        Assert.assertEquals(3, coordinate.getZ(), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceTestWithCartesianCoordinatesTest()
    {
        CartesianCoordinate coordinateOne = new CartesianCoordinate(1,2,3);
        CartesianCoordinate coordinateTwo = new CartesianCoordinate(4,5,6);
        Assert.assertEquals(5.196152, coordinateOne.getDistance(coordinateTwo), DOUBLE_TEST_DELTA);
    }
}
