package org.wahlzeit.model;

/**
 * Class that represents a coordinate consisting of a latitude and a longitude
 */
public interface Coordinate {

	/**
	 * Calculates the distance between two coordinates.
	 * @param coordinate The second coordinate
	 * @return Returns the distance in km
	 */
	double getDistance(Coordinate coordinate) ;

	boolean isEqual(Coordinate coordinate);

}