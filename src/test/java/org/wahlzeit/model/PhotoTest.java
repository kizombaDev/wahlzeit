package org.wahlzeit.model;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.assertNotNull;

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
		Location location = new Location();
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