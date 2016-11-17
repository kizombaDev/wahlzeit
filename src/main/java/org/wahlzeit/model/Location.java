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

import org.wahlzeit.model.coordinate.Coordinate;

/**
 * Represents the location of an object, for example the {@link Photo}
 */
public class Location  {

	private Coordinate coordinate;

	/**
	 *
	 * @param coordinate The coordinates of the location. Null is not allowed
	 */
	public Location(Coordinate coordinate)
	{
		if(coordinate == null)
		{
			throw new IllegalArgumentException("The parameter sphericCoordinate is null");
		}

		this.coordinate = coordinate;
	}

	/**
	 * Returns the coordinate of the location
	 * @return The coordinate of the location
	 */
	public Coordinate getSphericCoordinate() {
		return coordinate;
	}

	/**
	 * Calculates the distance between two locations.
	 * @param location The second location
	 * @return Returns the distance in km
	 */
	public double getDistance(Location location) {
		if(location == null)
		{
			throw new IllegalArgumentException("The parameter location is null");
		}

		return coordinate.getDistance(location.getSphericCoordinate());
	}
}
