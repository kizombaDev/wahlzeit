package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.coordinate.Coordinate;
import org.wahlzeit.model.coordinate.SphericCoordinate;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

	@Test
	public void testLocatioinRequireAlwaysACoordinate() {
		SphericCoordinate sphericCoordinate = new SphericCoordinate(0,0,0);
		Location location = new Location(sphericCoordinate);
		Coordinate actualSphericCoordinate = location.getSphericCoordinate();

		Assert.assertSame(sphericCoordinate, actualSphericCoordinate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowIllegalArgumentExceptionIfCoordinateIsNull(){
		new Location(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowIllegalArgumentExceptionIfLocationParameterOfGetDistanceIsNull(){
		new Location(new SphericCoordinate(0,0,0)).getDistance(null);
	}
}