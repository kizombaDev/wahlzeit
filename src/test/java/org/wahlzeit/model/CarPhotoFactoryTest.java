/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.exceptions.PhotoComponentException;

public class CarPhotoFactoryTest {

    private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalBlobstoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void createPhotoTest() {
        Assert.assertEquals(CarPhoto.class, CarPhotoFactory.getInstance().createPhoto().getClass());
    }

    @Test
    public void createPhotoWithIdTest() throws PhotoComponentException {
        Assert.assertEquals(CarPhoto.class, CarPhotoFactory.getInstance().createPhoto(new PhotoId(1)).getClass());
    }

    @Test
    public void createPhotoWithIdContainsTheIdTest() throws PhotoComponentException {
        Photo photo = CarPhotoFactory.getInstance().createPhoto(new PhotoId(1));
        Assert.assertEquals(1, photo.getId().asInt());
    }

    @Test
    public void getInstanceReturnsAlwaysTheSameReference() {
        Assert.assertSame(CarPhotoFactory.getInstance(), CarPhotoFactory.getInstance());
    }

    @Test(expected = IllegalStateException.class)
    public void callSetInstanceTwiceTrowIllegalStateExceptionTest() {
        CarPhotoFactory.getInstance();
        CarPhotoFactory.setInstance(null);

    }

    @Test(expected = PhotoComponentException.class)
    public void passNullToCreatePhotoTest() throws PhotoComponentException {
        CarPhotoFactory.getInstance().createPhoto(null);

    }
}
