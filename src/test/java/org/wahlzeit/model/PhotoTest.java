package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Photo}.
 */
public class PhotoTest {

	private Photo photo;

	@Before
	public void init() {
		photo = new Photo();
	}

	@Test
	public void testPhotoLocation() {
		Location location = new Location(new CartesianCoordinate(1,1,1));
		photo.setLocation(location);

		Assert.assertSame(location, photo.getLocation());
	}

	@Test
	public void testDefaultOfLocationIsNull() {
		Assert.assertNull(photo.getLocation());
	}
	@Test
	public void testLocationCanSetToNullWithoutException(){
		photo.setLocation(null);
	}
}