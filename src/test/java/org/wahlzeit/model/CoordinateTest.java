package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {
	private static final double SampleValue = 5.2;
	private static final double DELTA = 1e-15;
	private Coordinate coordinate;

	@Before
	public void init()	{
		coordinate = new Coordinate();
	}

	@Test
	public void testLatitude() {
		coordinate.latitude(SampleValue);
		Assert.assertEquals(SampleValue, coordinate.latitdue(), DELTA);
	}

	@Test
	public void testLongitude() {
		coordinate.longitude(SampleValue);
		Assert.assertEquals(SampleValue, coordinate.longitude(), DELTA);
	}
}