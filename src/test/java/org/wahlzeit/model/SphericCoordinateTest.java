package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SphericCoordinate}.
 */
public class SphericCoordinateTest {
    private static final double DEGREE_VALUE_DELTA = 1e-15;

    @Test
    public void testLatitude() {
        Assert.assertEquals(40.712784, getNewYorkCoordinate().getLatitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testLongitude() {
        Assert.assertEquals(-74.005941, getNewYorkCoordinate().getLongitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testRadius() {
        Assert.assertEquals(SphericCoordinate.EARTH_RADIUS_IN_KM, getNewYorkCoordinate().getRadius(), DEGREE_VALUE_DELTA);
    }

    private SphericCoordinate getNewYorkCoordinate() {
        return new SphericCoordinate(40.712784, -74.005941, SphericCoordinate.EARTH_RADIUS_IN_KM);
    }
}