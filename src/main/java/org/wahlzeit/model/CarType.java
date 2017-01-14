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

@Serialize
public class CarType {
    private final String make;
    private final String country;
    private final CarType baseCarType;

    public CarType(CarType baseCarType, String make, String country) {
        AssertUtil.assertParameterIsNotNullOrEmpty(make, "make");
        AssertUtil.assertParameterIsNotNullOrEmpty(country, "country");
        this.make = make;
        this.country = country;
        this.baseCarType = baseCarType;
    }

    public CarType(String make, String country) {
        this(null, make, country);
    }

    /**
     * @return
     * @methodtype get
     */
    public String getMake() {
        return make;
    }

    /**
     * @return
     * @methodtype get
     */
    public String getCounty() {
        return country;
    }

    /**
     * @return
     * @methodtype get
     */
    public CarType getBaseCarType() {
        return baseCarType;
    }

    /**
     * @return
     * @methodtype factory
     */
    public Car createInstance(String model, Fuel fuel, Color color, double weight) {
        return new Car(this, model, fuel, color, weight);
    }

    /**
     * @return
     * @methodtype boolean query
     */
    public boolean isSubtype(CarType type) {

        CarType currentType = baseCarType;

        while (currentType != null) {
            if (currentType == type) {
                return true;
            }

            currentType = baseCarType.getBaseCarType();
        }

        return false;
    }
}
