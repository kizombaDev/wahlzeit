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
 * Class that represents a coordinate consisting of latitude, longitude and radius
 */
public class SphericCoordinate extends AbstractCoordinate {
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


    @Override
    protected double getX() {
        return getRadius() * Math.sin(getLatitudeInRadius()) * Math.cos(getLongitudeInRadius());
    }

    @Override
    protected double getY() {
        return getRadius() * Math.sin(getLatitudeInRadius()) * Math.sin(getLongitudeInRadius());
    }

    @Override
    protected double getZ() {
        return getRadius() * Math.cos(getLatitudeInRadius());
    }

    private double getLatitudeInRadius() {
        return Math.toRadians(getLatitude());
    }

    private double getLongitudeInRadius() {
        return Math.toRadians(getLongitude());
    }

    /**
     * Gets the radius in km
     *
     * @return Radius in km
     */
    public double getRadius() {
        return radius;
    }
}