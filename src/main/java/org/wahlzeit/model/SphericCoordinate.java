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

import org.wahlzeit.utils.AssertUtil;

/**
 * Class that represents a coordinate consisting of latitude, longitude and radius
 */
public class SphericCoordinate implements Coordinate {
    public static final double EARTH_RADIUS_IN_KM = 6371;
    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    /**
     * Gets the longitude in degrees
     *
     * @return Longitude in degrees
     */
    public double getLatitude() {
        return latitude;
    }


    /**
     * Gets the longitude in degrees
     *
     * @return Longitude in degrees
     */
    public double getLongitude() {
        return longitude;
    }


    /**
     * Calculates the distance between two coordinates.
     *
     * @param coordinate The second sphericCoordinate
     * @return Returns the distance in km
     */
    @Override
    public double getDistance(Coordinate coordinate) {
        AssertUtil.assertIsParameterNull(coordinate, "coordinate");

        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        return cartesianCoordinate.getDistance(coordinate);
    }

    /**
     * Gets the radius in km
     *
     * @return Radius in km
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Converts the SphericCoordinate to a new object with cartesian coordinates
     *
     * @return
     */
    public CartesianCoordinate asCartesianCoordinate() {

        double latitudeInRadians = Math.toRadians(getLatitude());
        double longitudeInRadians = Math.toRadians(getLongitude());

        return new CartesianCoordinate(
                radius * Math.sin(latitudeInRadians) * Math.cos(longitudeInRadians),
                radius * Math.sin(latitudeInRadians) * Math.sin(longitudeInRadians),
                radius * Math.cos(latitudeInRadians));
    }
}