package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.wahlzeit.exceptions.CoordinateComponentException;

/**
 * Test class for {@link AbstractCoordinate}.
 */
public class AbstractCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    private AbstractCoordinate oneZeroZeroCoordinate;
    private AbstractCoordinate zeroZeroZeroCoordinate;
    private AbstractCoordinate oneTwoThreeCoordinate;
    private AbstractCoordinate fourFiveSixCoordinate;
    private AbstractCoordinate newYorkCoordinate;
    private AbstractCoordinate londonCoordinate;
    private AbstractCoordinate capetownCoordinate;

    private AbstractCoordinate createAbstractCoordinate(double x, double y, double z) {
        AbstractCoordinate coordinate = Mockito.mock(AbstractCoordinate.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(coordinate.getX()).thenReturn(x);
        Mockito.when(coordinate.getY()).thenReturn(y);
        Mockito.when(coordinate.getZ()).thenReturn(z);
        return coordinate;
    }

    @Before
    public void inti() {
        oneZeroZeroCoordinate = createAbstractCoordinate(1, 0, 0);
        zeroZeroZeroCoordinate = createAbstractCoordinate(0, 0, 0);
        oneTwoThreeCoordinate = createAbstractCoordinate(1, 2, 3);
        fourFiveSixCoordinate = createAbstractCoordinate(4, 5, 6);

        newYorkCoordinate = createAbstractCoordinate(1145.02, -3994.73, 4829.14);
        londonCoordinate = createAbstractCoordinate(4986.49, -11.11891530413514, 3965.40);
        capetownCoordinate = createAbstractCoordinate(-3373.43, -1123.76, 5286.46);
    }

    @Test
    public void getDistanceTestWithCartesianCoordinatesTest() throws CoordinateComponentException {

        Assert.assertEquals(5.196152, oneTwoThreeCoordinate.getDistance(fourFiveSixCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceWithZeroPoint() throws CoordinateComponentException {
        Assert.assertEquals(1, zeroZeroZeroCoordinate.getDistance(oneZeroZeroCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceBetweenTwoPointsWithTheSameLocation() throws CoordinateComponentException {
        Assert.assertEquals(0, oneTwoThreeCoordinate.getDistance(oneTwoThreeCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void isEqualWithNullCoordinate() throws CoordinateComponentException {
        Assert.assertFalse(zeroZeroZeroCoordinate.isEqual(null));
    }

    @Test
    public void isEqualWithTwoEqualCoordinates() throws CoordinateComponentException {
        CartesianCoordinate first = CartesianCoordinate.create(1, 2, 3);
        Assert.assertTrue(first.isEqual(oneTwoThreeCoordinate));
    }

    @Test
    public void isEqualWithTwoDifferentCoordinates() throws CoordinateComponentException {
        Assert.assertFalse(oneTwoThreeCoordinate.isEqual(zeroZeroZeroCoordinate));
    }

    @Test
    public void isEqualWithTheSameCoordinate() throws CoordinateComponentException {
        Assert.assertTrue(oneTwoThreeCoordinate.isEqual(oneTwoThreeCoordinate));
    }

    @Test
    public void equalWithNullCoordinate() throws CoordinateComponentException {
        Assert.assertFalse(zeroZeroZeroCoordinate.equals(null));
    }

    @Test
    public void equalWithTwoEqualCoordinates() throws CoordinateComponentException {
        CartesianCoordinate first = CartesianCoordinate.create(1, 2, 3);
        Assert.assertTrue(first.equals(oneTwoThreeCoordinate));
    }

    @Test
    public void equalWithTwoDifferentCoordinates() throws CoordinateComponentException {
        Assert.assertFalse(oneTwoThreeCoordinate.equals(zeroZeroZeroCoordinate));
    }

    @Test
    public void equalWithTheSameCoordinate() throws CoordinateComponentException {
        Assert.assertTrue(oneTwoThreeCoordinate.equals(oneTwoThreeCoordinate));
    }

    @Test
    public void getDistanceBetweenNewYorkAndLondon() throws CoordinateComponentException {
        Assert.assertEquals(5601.07988, newYorkCoordinate.getDistance(londonCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceBetweenNewYorkAndCapetown() throws CoordinateComponentException {
        Assert.assertEquals(5372.89500, newYorkCoordinate.getDistance(capetownCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceBetweenCapetownAndLondon() throws CoordinateComponentException {
        Assert.assertEquals(8536.47656, capetownCoordinate.getDistance(londonCoordinate), DOUBLE_TEST_DELTA);
    }
}
