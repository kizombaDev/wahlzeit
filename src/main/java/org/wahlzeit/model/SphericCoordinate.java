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
    protected static final ValueTypeCache<SphericCoordinate> cache = new ValueTypeCache<>();
    private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());
    private final double latitude;
    private final double longitude;
    private final double radius;


    private SphericCoordinate(double latitude, double longitude, double radius) throws CoordinateComponentException {
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

    public static SphericCoordinate create(double latitude, double longitude, double radius) throws CoordinateComponentException {
        SphericCoordinate key = new SphericCoordinate(latitude, longitude, radius);
        return cache.putIfAbsent(key);
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

    @Override
    public int hashCode() {
        //hash code implementation http://stackoverflow.com/a/113600/5888753
        int result = 41;
        long c = Double.doubleToLongBits(getLatitude());
        result = 37 * result + (int) (c ^ (c >>> 32));
        c = Double.doubleToLongBits(getLongitude());
        result = 37 * result + (int) (c ^ (c >>> 32));
        c = Double.doubleToLongBits(getRadius());
        result = 37 * result + (int) (c ^ (c >>> 32));
        return result;
    }

    public SphericCoordinate changeLatitude(double latitude) throws CoordinateComponentException {
        return new SphericCoordinate(latitude, getLongitude(), getRadius());
    }

    public SphericCoordinate changeLongitude(double longitude) throws CoordinateComponentException {
        return new SphericCoordinate(getLatitude(), longitude, getRadius());
    }

    public SphericCoordinate changeRadius(double radius) throws CoordinateComponentException {
        return new SphericCoordinate(getLatitude(), getLongitude(), radius);
    }
}