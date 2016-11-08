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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class CarPhotoTest {

    private CarPhoto carPhoto;

    @Before
    public void setUp()
    {
        carPhoto = new CarPhoto();
    }
    @Test
    public void fuelPropertyTest()
    {
        carPhoto.setFuel(Fuel.petrol);
        Assert.assertEquals(Fuel.petrol, carPhoto.getFuel());
    }

    @Test
    public void colorPropertyTest()
    {
        carPhoto.setColor(Color.black);
        Assert.assertEquals(Color.black, carPhoto.getColor());
    }

    @Test
    public void weightPropertyTest()
    {
        carPhoto.setWeight(1234.12);
        Assert.assertEquals(1234.12, carPhoto.getWeight(), 0.001);
    }


}
