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


import org.wahlzeit.exceptions.NullArgumentException;
import org.wahlzeit.utils.AssertUtil;

import java.awt.*;

public class CarPhoto extends Photo {

    protected Fuel fuel;
    protected Color color;
    protected double weight;

    /**
     *
     * @methodtype constructor
     */
    public CarPhoto() {
    }

    /**
     * @param myId
     * @methodtype constructor
     */
    public CarPhoto(PhotoId myId) {
        super(myId);

        if (myId == null) {
            throw new NullArgumentException("myId");
        }
    }

    /**
     *
     * @return
     * @methodtype get
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @return
     * @methodtype set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * @methodtype get
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @return
     * @methodtype set
     */
    public void setColor(Color color) {
        AssertUtil.assertParameterIsNotNull(color, "color");
        this.color = color;
    }

    /**
     *
     * @return
     * @methodtype get
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     *
     * @return
     * @methodtype set
     */
    public void setFuel(Fuel fuel) {
        AssertUtil.assertParameterIsNotNull(fuel, "fuel");
        this.fuel = fuel;
    }
}
