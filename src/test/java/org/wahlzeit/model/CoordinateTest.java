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

	@Test
	public void testDistanceBetweenNewYorkAndLondon()
	{
		Coordinate newYork = new Coordinate();
		newYork.longitude(-74.005941);
		newYork.latitude(40.712784);

		Coordinate london = new Coordinate();
		london.longitude(-0.1277583);
		london.latitude(51.5073509);

		Assert.assertEquals(5570, newYork.getDistance(london), 1);
	}

	@Test
	public void testDistanceBetweenCapetownAndLondon()
	{
		Coordinate capetown = new Coordinate();
		capetown.longitude(18.424055);
		capetown.latitude(-33.924869);

		Coordinate london = new Coordinate();
		london.longitude(-0.1277583);
		london.latitude(51.5073509);

		Assert.assertEquals(9670, capetown.getDistance(london), 1);
	}
}