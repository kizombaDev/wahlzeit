package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Test class for {@link AbstractCoordinate}.
 */
public class AbstractCoordinateTest {

    private static final double DOUBLE_TEST_DELTA = 1e-5;

    private final AbstractCoordinate oneZeroZeroCoordinate = createAbstractCoordinate(1, 0, 0);
    private final AbstractCoordinate zeroZeroZeroCoordinate = createAbstractCoordinate(0, 0, 0);
    private final AbstractCoordinate oneTwoThreeCoordinate = createAbstractCoordinate(1, 2, 3);
    private final AbstractCoordinate fourFiveSixCoordinate = createAbstractCoordinate(4, 5, 6);

    private AbstractCoordinate createAbstractCoordinate(double x, double y, double z) {
        AbstractCoordinate coordinate = Mockito.mock(AbstractCoordinate.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(coordinate.getX()).thenReturn(x);
        Mockito.when(coordinate.getY()).thenReturn(y);
        Mockito.when(coordinate.getZ()).thenReturn(z);
        return coordinate;
    }

    @Test
    public void getDistanceTestWithCartesianCoordinatesTest() {

        Assert.assertEquals(5.196152, oneTwoThreeCoordinate.getDistance(fourFiveSixCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceWithZeroPoint() {
        Assert.assertEquals(1, zeroZeroZeroCoordinate.getDistance(oneZeroZeroCoordinate), DOUBLE_TEST_DELTA);
    }

    @Test
    public void getDistanceBetweenTwoPointsWithTheSameLocation() {
        Assert.assertEquals(0, oneTwoThreeCoordinate.getDistance(oneTwoThreeCoordinate), DOUBLE_TEST_DELTA);
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
