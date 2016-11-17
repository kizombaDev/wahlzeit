package org.wahlzeit.model.coordinate;

public interface Coordinate {
    /**
     * Calculates the distance between two coordinates.
     * @param coordinate The second coordinate
     * @return Returns the distance in km
     */
    double getDistance(Coordinate coordinate);
}
