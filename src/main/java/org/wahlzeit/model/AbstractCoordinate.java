package org.wahlzeit.model;

import org.wahlzeit.exceptions.CoordinateComponentException;
import org.wahlzeit.utils.AssertUtil;
import org.wahlzeit.utils.DoubleUtil;
import org.wahlzeit.utils.PatternInstance;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "TemplateMethod",
        participants = {"AbstractCoordinate", "CartesianCoordinate", "SphericCoordinate"})
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

    @Override
    public boolean equals(Object o) {
        try {
            return isEqual((o instanceof Coordinate) ? (Coordinate) o : null);
        } catch (CoordinateComponentException e) {
            throw new IllegalStateException(e);
            //This is a big disadvantage of checked exceptions. I can not add the checked exception CoordinateComponentException to the signature of the method
            //because this is an inherited method of object and it is not permissible for me to change the object class in the JDK
        }
    }

    @Override
    public int hashCode() {
        //hash code implementation http://stackoverflow.com/a/113600/5888753
        int result = 41;
        long c = Double.doubleToLongBits(getX());
        result = 37 * result + (int) (c ^ (c >>> 32));
        c = Double.doubleToLongBits(getY());
        result = 37 * result + (int) (c ^ (c >>> 32));
        c = Double.doubleToLongBits(getZ());
        result = 37 * result + (int) (c ^ (c >>> 32));
        return result;
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
