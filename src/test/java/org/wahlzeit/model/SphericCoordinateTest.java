package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SphericCoordinate}.
 */
public class SphericCoordinateTest {
    private static final double DEGREE_VALUE_DELTA = 1e-15;

    private SphericCoordinate newYorkCoordinate;
    private SphericCoordinate emptyCoordinate;

    @Before
    public void init() {
        emptyCoordinate = new SphericCoordinate(0, 0, 0);
        newYorkCoordinate = new SphericCoordinate(40.712784, -74.005941, SphericCoordinate.EARTH_RADIUS_IN_KM);
    }

    @Test
    public void testLatitude() {
        Assert.assertEquals(40.712784, newYorkCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testLongitude() {
        Assert.assertEquals(-74.005941, newYorkCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testRadius() {
        Assert.assertEquals(SphericCoordinate.EARTH_RADIUS_IN_KM, newYorkCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }


    @Test
    public void testSetLatitude() {
        emptyCoordinate.setLatitude(42);
        Assert.assertEquals(42, emptyCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetLongitude() {
        emptyCoordinate.setLongitude(42);
        Assert.assertEquals(42, emptyCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetRadius() {
        emptyCoordinate.setRadius(42);
        Assert.assertEquals(42, emptyCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }

    @Test(expected = AssertionError.class)
    public void testInvalidNegativeRadius() {
        emptyCoordinate.setRadius(-1);
    }

    @Test
    public void testNinetyDegreeIsValidLatitude() {
        emptyCoordinate.setLatitude(90);
    }

    @Test(expected = AssertionError.class)
    public void testNinetyOneDegreeIsInvalidLatitude() {
        emptyCoordinate.setLatitude(91);
    }

    @Test
    public void testMinusNinetyDegreeIsValidLatitude() {
        emptyCoordinate.setLatitude(-90);
    }

    @Test(expected = AssertionError.class)
    public void testMinusNinetyOneDegreeIsInvalidLatitude() {
        emptyCoordinate.setLatitude(-91);
    }

    @Test
    public void testOneHundredAndEightyDegreeIsValidLongitude() {
        emptyCoordinate.setLongitude(180);
    }

    @Test(expected = AssertionError.class)

    public void testOneHundredAndEightyOneDegreeIsInvalidLongitude() {
        emptyCoordinate.setLongitude(181);
    }

    @Test(expected = AssertionError.class)
    public void testMinusOneHundredAndEightyDegreeIsValidLongitude() {
        emptyCoordinate.setLongitude(-180);
    }

    @Test(expected = AssertionError.class)

    public void testMinusOneHundredAndEightyOneDegreeIsInvalidLongitude() {
        emptyCoordinate.setLongitude(-181);
    }
}