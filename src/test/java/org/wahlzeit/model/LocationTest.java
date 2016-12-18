package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.exceptions.CoordinateComponentException;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

	@Test
	public void testLocatioinRequireAlwaysACoordinate() throws CoordinateComponentException {
        Coordinate coordinate = CartesianCoordinate.create(1, 1, 1);
        Location location = new Location(coordinate);
		Coordinate actualCoordinate = location.getCoordinate();

		Assert.assertSame(coordinate, actualCoordinate);
	}

	@Test(expected = CoordinateComponentException.class)
	public void testThrowIllegalArgumentExceptionIfCoordinateIsNull() throws CoordinateComponentException {
		new Location(null);
	}

	@Test(expected = CoordinateComponentException.class)
	public void testThrowIllegalArgumentExceptionIfLocationParameterOfGetDistanceIsNull() throws CoordinateComponentException {
        new Location(CartesianCoordinate.create(1, 1, 1)).getDistance(null);
    }
}