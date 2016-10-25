package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

	@Test
	public void testLocatioinRequireAlwaysACoordinate() {
		Coordinate coordinate = new Coordinate();
		Location location = new Location(coordinate);
		Coordinate actualCoordinate = location.getCoordinate();

		Assert.assertSame(coordinate, actualCoordinate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionIfCoordinateIsNull(){
		new Location(null);
	}
}