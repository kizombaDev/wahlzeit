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

/**
 * Class that represents a coordinate consisting of a latitude and a longitude
 */
public class Coordinate {
	private double latitude;
	private double longitude;

	/**
	 * Sets the latitude degrees
	 * @param value Latitude degrees
	 */
	public void latitude(double value) {
		latitude = value;
	}

	/**
	 * Gets the longitude in degrees
	 * @return Longitude in degrees
	 */
	public double latitude() {
		return latitude;
	}

	/**
	 * Sets the longitude degrees
	 * @param value Longitude degrees
	 */
	public void longitude(double value) {
		longitude = value;
	}

	/**
	 * Gets the longitude in degrees
	 * @return Longitude in degrees
	 */
	public double longitude() {
		return longitude;
	}

	/**
	 * Calculates the distance between two coordinates.
	 * @param coordinate The second coordinate
	 * @return Returns the distance in km
	 */
	public double getDistance(Coordinate coordinate) {
		double earthRadius = 6371;

		double absoluteLongitudeDifferenceInRad = Math.toRadians(Math.abs(coordinate.longitude() - longitude()));
		double firstLatitudeInRad = Math.toRadians(latitude());
		double secondLatitudeInRad = Math.toRadians(coordinate.latitude());

		double dividend = Math.sqrt(Math.pow(Math.cos(secondLatitudeInRad) * Math.sin(absoluteLongitudeDifferenceInRad), 2) + Math.pow(Math.cos(firstLatitudeInRad) * Math.sin(secondLatitudeInRad) - Math.sin(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * Math.cos(absoluteLongitudeDifferenceInRad), 2));
		double divisor = Math.sin(firstLatitudeInRad) * Math.sin(secondLatitudeInRad) + Math.cos(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * Math.cos(absoluteLongitudeDifferenceInRad);

		return Math.atan(dividend / divisor) * earthRadius;
	}
}