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
        emptyCoordinate = SphericCoordinate.create(0, 0, 0);
        newYorkCoordinate = SphericCoordinate.create(40.712784, -74.005941, SphericCoordinate.EARTH_RADIUS_IN_KM);
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
        emptyCoordinate = SphericCoordinate.create(42, 0, 0);
        Assert.assertEquals(42, emptyCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetLongitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, 42, 0);
        Assert.assertEquals(42, emptyCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void testSetRadius() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, 0, 42);
        Assert.assertEquals(42, emptyCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testInvalidNegativeRadius() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, 0, -1);
    }

    @Test
    public void testNinetyDegreeIsValidLatitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(90, 0, 0);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testNinetyOneDegreeIsInvalidLatitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(91, 0, 0);
    }

    @Test
    public void testMinusNinetyDegreeIsValidLatitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(-90, 0, 0);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusNinetyOneDegreeIsInvalidLatitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(-91, 0, 0);
    }

    @Test
    public void testOneHundredAndEightyDegreeIsValidLongitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, 180, 0);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testOneHundredAndEightyOneDegreeIsInvalidLongitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, 181, 0);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusOneHundredAndEightyDegreeIsValidLongitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(0, -180, 0);
    }

    @Test(expected = CoordinateComponentException.class)
    public void testMinusOneHundredAndEightyOneDegreeIsInvalidLongitude() throws CoordinateComponentException {
        emptyCoordinate = SphericCoordinate.create(42, -181, 0);
    }

    @Test
    public void twoCoordinatesWithTheSameDoublesShouldBeTheSame() throws CoordinateComponentException {
        Assert.assertSame(SphericCoordinate.create(4, 0, 0), SphericCoordinate.create(4, 0, 0));
    }

    @Test
    public void twoCoordinatesWithDifferentDoublesShouldNotBeTheSame() throws CoordinateComponentException {
        Assert.assertNotSame(SphericCoordinate.create(5, 0, 0), SphericCoordinate.create(4, 0, 0));
    }

    @Test
    public void changeLatitudeTest() throws CoordinateComponentException {
        SphericCoordinate oneTwoThreeCoordinate = SphericCoordinate.create(1, 2, 3);

        SphericCoordinate changeCoordinate = oneTwoThreeCoordinate.changeLatitude(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(42, changeCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(2, changeCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(3, changeCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void changeLongitudeTest() throws CoordinateComponentException {
        SphericCoordinate oneTwoThreeCoordinate = SphericCoordinate.create(1, 2, 3);

        SphericCoordinate changeCoordinate = oneTwoThreeCoordinate.changeLongitude(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(1, changeCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(42, changeCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(3, changeCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }

    @Test
    public void changeRadiusTest() throws CoordinateComponentException {
        SphericCoordinate oneTwoThreeCoordinate = SphericCoordinate.create(1, 2, 3);

        SphericCoordinate changeCoordinate = oneTwoThreeCoordinate.changeRadius(42);

        Assert.assertNotSame(changeCoordinate, oneTwoThreeCoordinate);
        Assert.assertEquals(1, changeCoordinate.getLatitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(2, changeCoordinate.getLongitude(), DEGREE_VALUE_DELTA);
        Assert.assertEquals(42, changeCoordinate.getRadius(), DEGREE_VALUE_DELTA);
    }
}