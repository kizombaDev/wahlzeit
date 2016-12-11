package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Serialize;
import org.wahlzeit.exceptions.CoordinateComponentException;

/**
 * Class that represents a coordinate consisting of a latitude and a longitude
 */
@Serialize
public interface Coordinate {

    /**
     * Calculates the distance between two coordinates.
     *
     * @param coordinate The second coordinate
     * @return Returns the distance in km
     * @methodtype get
     */
    double getDistance(Coordinate coordinate) throws CoordinateComponentException;

    /**
     * Determines whether two coordinates are equal
     *
     * @param coordinate
     * @return true if the two coordinates are equal, otherwise false
     * @methodtype get
     */
    boolean isEqual(Coordinate coordinate) throws CoordinateComponentException;
}