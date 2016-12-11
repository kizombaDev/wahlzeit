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

import org.wahlzeit.exceptions.CoordinateComponentException;

import java.util.logging.Logger;

/**
 * Class that represents a coordinate consisting of latitude, longitude and radius
 */
public class SphericCoordinate extends AbstractCoordinate {
    public static final double EARTH_RADIUS_IN_KM = 6371;
    private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());
    private double latitude;
    private double longitude;
    private double radius;


    public SphericCoordinate(double latitude, double longitude, double radius) throws CoordinateComponentException {
        try {
            assertLatitude(latitude);
            assertLongitude(longitude);
            assertRadius(radius);

            this.latitude = latitude;
            this.longitude = longitude;
            this.radius = radius;
        } catch (Throwable e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
    }

    /**
     * @param radius
     * @methodtype assert
     */
    private void assertRadius(double radius) {
        assert radius >= 0 : "A negative radius is not supported";
    }

    /**
     * @param longitude
     * @methodtype assert
     */
    private void assertLongitude(double longitude) {
        assert longitude <= 180.0 && longitude > -180.0 : "longitude must be equal to +180 or greater than -180 and smaller degrees";
    }

    /**
     * @param latitude
     * @methodtype assert
     */
    private void assertLatitude(double latitude) {
        assert Math.abs(latitude) <= 90.0 : "latitude must be between -90 and +90 degrees";
    }

    /**
     * Gets the latitude in degrees
     *
     * @return latitude in degrees
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude in degrees
     *
     * @param latitude
     */
    public void setLatitude(double latitude) throws CoordinateComponentException {
        try {
            assertLatitude(latitude);
            this.latitude = latitude;
            assertClassInvariants();
        } catch (Throwable e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
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
     * Sets the longitude in degrees
     *
     * @param longitude
     */
    public void setLongitude(double longitude) throws CoordinateComponentException {
        try {
            assertLongitude(longitude);
            this.longitude = longitude;
            assertClassInvariants();
        } catch (Throwable e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
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

    @Override
    protected void assertClassInvariants() {
        assertLatitude(getLatitude());
        assertLongitude(getLongitude());
        assertRadius(getRadius());
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

    public void setRadius(double radius) throws CoordinateComponentException {
        try {
            assertRadius(radius);
            this.radius = radius;
            assertClassInvariants();
        } catch (Throwable e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
    }
}