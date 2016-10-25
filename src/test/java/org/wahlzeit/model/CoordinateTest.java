package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {
	private static final double SampleValue = 5.2;
	private static final double DELTA = 1e-15;

	@Test
	public void testLatitude() {
		Coordinate coordinate = new Coordinate();
		coordinate.latitude(SampleValue);
		Assert.assertEquals(SampleValue, coordinate.latitdue(), DELTA);
	}

	@Test
	public void testLongitude() {
		Coordinate coordinate = new Coordinate();
		coordinate.longitude(SampleValue);
		Assert.assertEquals(SampleValue, coordinate.longitude(), DELTA);
	}
}