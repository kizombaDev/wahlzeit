package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.exceptions.CoordinateComponentException;

/**
 * Test class for {@link SphericCoordinate}.
 */
public class SphericCoordinateTest {
    private static final double DEGREE_VALUE_DELTA = 1e-15;

    private SphericCoordinate newYorkCoordinate;
    private SphericCoordinate emptyCoordinate;

    @Before
    public void init() throws CoordinateComponentException {
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
    public void testSetLatitude() throws CoordinateComponentException {
        emptyCoordinate.setLatitude(42);
        Assert.assertEquals(42, emptyCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetLongitude() throws CoordinateComponentException {
        emptyCoordinate.setLongitude(42);
        Assert.assertEquals(42, emptyCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetRadius() throws CoordinateComponentException {
        emptyCoordinate.setRadius(42);
        Assert.assertEquals(42, emptyCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testInvalidNegativeRadius() throws CoordinateComponentException {
        emptyCoordinate.setRadius(-1);
    }

    @Test
    public void testNinetyDegreeIsValidLatitude() throws CoordinateComponentException {
        emptyCoordinate.setLatitude(90);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testNinetyOneDegreeIsInvalidLatitude() throws CoordinateComponentException {
        emptyCoordinate.setLatitude(91);
    }

    @Test
    public void testMinusNinetyDegreeIsValidLatitude() throws CoordinateComponentException {
        emptyCoordinate.setLatitude(-90);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusNinetyOneDegreeIsInvalidLatitude() throws CoordinateComponentException {
        emptyCoordinate.setLatitude(-91);
    }

    @Test
    public void testOneHundredAndEightyDegreeIsValidLongitude() throws CoordinateComponentException {
        emptyCoordinate.setLongitude(180);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testOneHundredAndEightyOneDegreeIsInvalidLongitude() throws CoordinateComponentException {
        emptyCoordinate.setLongitude(181);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusOneHundredAndEightyDegreeIsValidLongitude() throws CoordinateComponentException {
        emptyCoordinate.setLongitude(-180);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusOneHundredAndEightyOneDegreeIsInvalidLongitude() throws CoordinateComponentException {
        emptyCoordinate.setLongitude(-181);
    }
}