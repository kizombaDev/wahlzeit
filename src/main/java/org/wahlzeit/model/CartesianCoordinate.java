package org.wahlzeit.model;

import java.util.logging.Logger;

public class CartesianCoordinate extends AbstractCoordinate {

    private static final Logger log = Logger.getLogger(CartesianCoordinate.class.getName());
    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) {
        try {
            this.x = x;
            this.y = y;
            this.z = z;
            assertClassInvariants();
        } catch (Exception e) {
            log.warning(e.toString());
            throw e;
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

    @Override
    protected void assertClassInvariants() {
        assertIsValidDoubleRange(getX());
        assertIsValidDoubleRange(getY());
        assertIsValidDoubleRange(getZ());
    }

    private void assertIsValidDoubleRange(double value) throws IllegalArgumentException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new IllegalArgumentException("Double value is not valid" + value);
    }
}
