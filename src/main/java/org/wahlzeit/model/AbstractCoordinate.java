package org.wahlzeit.model;

import org.wahlzeit.utils.AssertUtil;
import org.wahlzeit.utils.DoubleUtil;

public abstract class AbstractCoordinate implements Coordinate {
    /**
     * Calculates the distance between two coordinates.
     *
     * @param coordinate The second coordinate
     * @return Returns the distance in km
     */
    @Override
    public double getDistance(Coordinate coordinate) {
        AssertUtil.assertParameterIsNotNull(coordinate, "coordinate");
        assertAbstractCoordinateType(coordinate);
        assertClassInvariants();

        AbstractCoordinate abstractCoordinate = (AbstractCoordinate) coordinate;
        return doGetDistance(abstractCoordinate);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {

        if (coordinate == null) {
            return false;
        }

        if (this == coordinate) {
            return true;
        }

        assertClassInvariants();
        assertAbstractCoordinateType(coordinate);

        AbstractCoordinate abstractCoordinate = (AbstractCoordinate) coordinate;

        return DoubleUtil.equals(abstractCoordinate.getX(), getX()) && DoubleUtil.equals(abstractCoordinate.getY(), getY()) && DoubleUtil.equals(abstractCoordinate.getZ(), getZ());
    }

    private void assertAbstractCoordinateType(Coordinate coordinate) {
        if (coordinate instanceof AbstractCoordinate == false) {
            throw new IllegalStateException("Unknown coordinate type");
        }
    }

    private double doGetDistance(AbstractCoordinate coordinate) {
        double deltaX = getX() - coordinate.getX();
        double deltaY = getY() - coordinate.getY();
        double deltaZ = getZ() - coordinate.getZ();

        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

        assert distance >= 0 : "A negative distance is an invalid distance";

        return distance;
    }

    protected abstract double getX();

    protected abstract double getY();

    protected abstract double getZ();

    protected abstract void assertClassInvariants();
}
