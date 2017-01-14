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

import com.googlecode.objectify.annotation.Serialize;
import org.wahlzeit.utils.AssertUtil;

import java.awt.*;
import java.security.InvalidParameterException;

@Serialize
public class Car {
    protected final CarType carType;
    protected final String model;
    protected final Fuel fuel;
    protected final Color color;
    protected final double weight;

    public Car(CarType carType, String model, Fuel fuel, Color color, double weight) {
        AssertUtil.assertParameterIsNotNull(carType, "carType");
        AssertUtil.assertParameterIsNotNull(fuel, "fuel");
        AssertUtil.assertParameterIsNotNull(color, "color");
        AssertUtil.assertParameterIsNotNullOrEmpty(model, "model");
        assertCarWeight(weight);

        this.carType = carType;
        this.model = model;
        this.fuel = fuel;
        this.color = color;
        this.weight = weight;
    }

    /**
     * @return
     * @methodtype get
     */
    public CarType getType() {
        return carType;
    }

    /**
     * @return
     * @methodtype get
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return
     * @methodtype get
     */
    public Color getColor() {
        return color;
    }


    /**
     * @return
     * @methodtype get
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * @return
     * @methodtype get
     */
    public String getModel() {
        return model;
    }

    /**
     * @return
     * @methodtype assert
     */
    private void assertCarWeight(double weight) {
        if (weight <= 0) {
            throw new InvalidParameterException("The weight of the car should be greater than zero");
        }
    }
}
