package org.wahlzeit.model.persistence;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.Assert.fail;

/**
 * Test class for {@link DatastoreAdapter}
 *
 * @review
 */
public class DatastoreAdapterTest {

    @ClassRule
    public static TestRule chain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());
    protected ImageStorage imageStorage;
    protected Image smallTestImage;
    protected Image maxSizeTestImage;
    private Image tooLargeTestImage;

    @Before
    public void SetUp() {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        smallTestImage = ImagesServiceFactory.makeImage(bb.array());

        bb = ByteBuffer.allocate(1024 * 1023);
        maxSizeTestImage = ImagesServiceFactory.makeImage(bb.array());

        storageDependentSetUp();
    }

    private void storageDependentSetUp() {
        imageStorage = new DatastoreAdapter();

        ByteBuffer bb = ByteBuffer.allocate(1024 * 1025);
        tooLargeTestImage = ImagesServiceFactory.makeImage(bb.array());
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testUpperSizeLimit() {
        try {
            imageStorage.writeImage(tooLargeTestImage, "blub", 1);
        } catch (IOException e) {
            fail("IOException should not be thrown!");
        }
    }
}
