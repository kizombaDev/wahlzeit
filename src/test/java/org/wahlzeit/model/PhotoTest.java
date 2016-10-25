package org.wahlzeit.model;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.junit.Assert;
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


	@Test
	public void testPhotoLocation() {
		Photo photo = new Photo();
		Location location = new Location();
		photo.setLocation(location);

		Assert.assertSame(location, photo.getLocation());

	}
}