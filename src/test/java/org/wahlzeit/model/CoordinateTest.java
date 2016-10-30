package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {
	private static final double SAMPLE_DEGREE_VALUE = 5.2;
	private static final double DEGREE_VALUE_DELTA = 1e-15;
	private static final double DISTANCE_VALUE_DELTA = 1e-5;
	private Coordinate coordinate;

	@Before
	public void init()	{
		coordinate = new Coordinate();
	}

	@Test
	public void testLatitude() {
		coordinate.latitude(SAMPLE_DEGREE_VALUE);
		Assert.assertEquals(SAMPLE_DEGREE_VALUE, coordinate.latitude(), DEGREE_VALUE_DELTA);
	}

	@Test
	public void testLongitude() {
		coordinate.longitude(SAMPLE_DEGREE_VALUE);
		Assert.assertEquals(SAMPLE_DEGREE_VALUE, coordinate.longitude(), DEGREE_VALUE_DELTA);
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

		Assert.assertEquals(5570, newYork.getDistance(london), DISTANCE_VALUE_DELTA);
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

		Assert.assertEquals(9670, capetown.getDistance(london), DISTANCE_VALUE_DELTA);
	}
}