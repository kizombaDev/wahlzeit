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
import org.wahlzeit.exceptions.PhotoComponentException;

public class CarPhoto extends Photo {

    private Car car;

    /**
     * @methodtype constructor
     */
    public CarPhoto() {
    }

    /**
     * @param myId
     * @methodtype constructor
     */
    public CarPhoto(PhotoId myId) throws PhotoComponentException {
        super(myId);
        if (myId == null) {
            throw new PhotoComponentException(new NullArgumentException("myId"));
        }
    }

    /**
     * @return
     * @methodtype get
     */
    public Car getCar() {
        return car;
    }

    /**
     * @return
     * @methodtype set
     */
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPhoto carPhoto = (CarPhoto) o;

        return getCar() != null ? getCar().equals(carPhoto.getCar()) : carPhoto.getCar() == null;
    }

    @Override
    public int hashCode() {
        return getCar() != null ? getCar().hashCode() : 0;
    }
}
