package org.wahlzeit.model;

import org.wahlzeit.exceptions.CoordinateComponentException;
import org.wahlzeit.utils.AssertUtil;
import org.wahlzeit.utils.DoubleUtil;

import java.util.logging.Logger;

public abstract class AbstractCoordinate implements Coordinate {

    private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());

    /**
     * Calculates the distance between two coordinates.
     *
     * @param coordinate The second coordinate
     * @return Returns the distance in km
     */
    @Override
    public double getDistance(Coordinate coordinate) throws CoordinateComponentException {
        try {
            AssertUtil.assertParameterIsNotNull(coordinate, "coordinate");
            assertAbstractCoordinateType(coordinate);
            assertClassInvariants();

            AbstractCoordinate abstractCoordinate = (AbstractCoordinate) coordinate;
            return doGetDistance(abstractCoordinate);
        } catch (Exception e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
    }

    @Override
    public boolean isEqual(Coordinate coordinate) throws CoordinateComponentException {
        try {
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
        } catch (Exception e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
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
