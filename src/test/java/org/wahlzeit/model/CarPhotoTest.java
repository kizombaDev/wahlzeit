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

import java.awt.*;

/**
 * Test class for {@link CarPhoto}.
 */
public class CarPhotoTest {

    private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalBlobstoreServiceTestConfig());
    private CarPhoto carPhoto;

    @Before
    public void setUp() {
        helper.setUp();
        carPhoto = new CarPhoto();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test(expected = PhotoComponentException.class)
    public void passNullToConstructorTest() throws PhotoComponentException {
        new CarPhoto(null);
    }

    @Test
    public void carPropertyTest() {
        Car a3 = CarManager.builder().createMake("Audi", "Germany").build().createCar("Audi", "A3", Fuel.diesel, Color.black, 1478.4);
        carPhoto.setCar(a3);

        Assert.assertSame(a3, carPhoto.getCar());
    }
}
