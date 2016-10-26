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
 *
 */
public class Coordinate {
	protected double latitude;
	protected double longitude;

	public void latitude(double value) {
		latitude = value;
	}

	public double latitdue() {
		return latitude;
	}

	public void longitude(double value) {
		longitude = value;
	}

	public double longitude() {
		return longitude;
	}

	public double getDistance(Coordinate coordinate) {
		double earthRadius = 6371;

		double absoluteLongitudeDifferenceInRad = Math.toRadians(Math.abs(coordinate.longitude() - longitude()));
		double firstLatitudeInRad = Math.toRadians(latitdue());
		double secondLatitudeInRad = Math.toRadians(coordinate.latitdue());

		double dividend = Math.sqrt(Math.pow(Math.cos(secondLatitudeInRad) * Math.sin(absoluteLongitudeDifferenceInRad), 2) + Math.pow(Math.cos(firstLatitudeInRad) * Math.sin(secondLatitudeInRad) - Math.sin(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * Math.cos(absoluteLongitudeDifferenceInRad), 2));
		double divisor = Math.sin(firstLatitudeInRad) * Math.sin(secondLatitudeInRad) + Math.cos(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * Math.cos(absoluteLongitudeDifferenceInRad);

		return Math.atan(dividend / divisor) * earthRadius;
	}
}