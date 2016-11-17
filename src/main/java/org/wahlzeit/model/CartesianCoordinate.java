package org.wahlzeit.model;

import org.wahlzeit.utils.AssertUtil;

public class CartesianCoordinate implements Coordinate {

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        AssertUtil.assertIsParameterNull(coordinate, "coordinate");

        if (coordinate instanceof SphericCoordinate) {
            SphericCoordinate sphericCoordinate = (SphericCoordinate) coordinate;
            return doGetDistance(sphericCoordinate.asCartesianCoordinate());
        } else if (coordinate instanceof CartesianCoordinate) {
            return doGetDistance((CartesianCoordinate) coordinate);
        } else {
            throw new IllegalStateException("coordinate is a unknown type");
        }
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public double getZ() {
        return z;
    }

    private double doGetDistance(CartesianCoordinate cartesianCoordinate) {
        AssertUtil.assertIsParameterNull(cartesianCoordinate, "cartesianCoordinate");

        double deltaX = getX() - cartesianCoordinate.getX();
        double deltaY = getY() - cartesianCoordinate.getY();
        double deltaZ = getZ() - cartesianCoordinate.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }
}
