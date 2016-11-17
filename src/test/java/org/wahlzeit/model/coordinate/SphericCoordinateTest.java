package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SphericCoordinate}.
 */
public class SphericCoordinateTest {
	private static final double DEGREE_VALUE_DELTA = 1e-15;
	private static final double DISTANCE_VALUE_DELTA = 1e-5;

	@Test
	public void testLatitude() {
		Assert.assertEquals(40.712784, getNewYorkCoordinate().getLatitude(), DEGREE_VALUE_DELTA);
	}

	@Test
	public void testLongitude() {
		Assert.assertEquals(-74.005941, getNewYorkCoordinate().getLongitude(), DEGREE_VALUE_DELTA);
	}

	@Test
	public void testRadius() {
		Assert.assertEquals(SphericCoordinate.EARTH_RADIUS_IN_KM, getNewYorkCoordinate().getRadius(), DEGREE_VALUE_DELTA);
	}

	@Test
	public void testDistanceBetweenNewYorkAndLondon()
	{
		Coordinate newYork = getNewYorkCoordinate();
		SphericCoordinate london = getLondonCoordinate();

		Assert.assertEquals(5570.22387, newYork.getDistance(london), DISTANCE_VALUE_DELTA);
	}

	@Test
	public void testDistanceBetweenCapetownAndLondon()
	{
		Coordinate capetown = getCapetownCoordinate();
		SphericCoordinate london = getLondonCoordinate();

		Assert.assertEquals(9670.99055, capetown.getDistance(london), DISTANCE_VALUE_DELTA);
	}

	@Test
	public void testCartesionCoordinate()
	{
		SphericCoordinate capetown = getCapetownCoordinate();
		CartesianCoordinate captownAsCartesion = capetown.asCartesionCoordinate();
		Assert.assertEquals(-3373.436487,captownAsCartesion.getX(), DISTANCE_VALUE_DELTA);
		Assert.assertEquals(-1123.766205,captownAsCartesion.getY(), DISTANCE_VALUE_DELTA);
		Assert.assertEquals(5286.465434,captownAsCartesion.getZ(), DISTANCE_VALUE_DELTA);
	}

	private SphericCoordinate getNewYorkCoordinate() {
		return new SphericCoordinate(40.712784, -74.005941, SphericCoordinate.EARTH_RADIUS_IN_KM);
	}

	private SphericCoordinate getLondonCoordinate() {
		return new SphericCoordinate(51.5073509, -0.1277583, SphericCoordinate.EARTH_RADIUS_IN_KM);
	}

	private SphericCoordinate getCapetownCoordinate() {
		return new SphericCoordinate(-33.924869, 18.424055, SphericCoordinate.EARTH_RADIUS_IN_KM);
	}
}