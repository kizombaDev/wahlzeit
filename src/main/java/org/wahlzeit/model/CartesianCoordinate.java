package org.wahlzeit.model;

import org.wahlzeit.exceptions.CoordinateComponentException;
import org.wahlzeit.utils.PatternInstance;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Value Object",
        participants = {"CartesianCoordinate"})
public class CartesianCoordinate extends AbstractCoordinate {

    protected static final ValueTypeCache<CartesianCoordinate> cache = new ValueTypeCache<>();
    private static final Logger log = Logger.getLogger(CartesianCoordinate.class.getName());
    private final double x;
    private final double y;
    private final double z;

    private CartesianCoordinate(double x, double y, double z) throws CoordinateComponentException {
        try {
            this.x = x;
            this.y = y;
            this.z = z;
            assertClassInvariants();
        } catch (Exception e) {
            log.warning(e.toString());
            throw new CoordinateComponentException(e);
        }
    }

    public static CartesianCoordinate create(double x, double y, double z) throws CoordinateComponentException {
        CartesianCoordinate key = new CartesianCoordinate(x, y, z);
        return cache.putIfAbsent(key);
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

    public CartesianCoordinate changeX(double x) throws CoordinateComponentException {
        return new CartesianCoordinate(x, getY(), getZ());
    }

    public CartesianCoordinate changeY(double y) throws CoordinateComponentException {
        return new CartesianCoordinate(getX(), y, getZ());
    }

    public CartesianCoordinate changeZ(double z) throws CoordinateComponentException {
        return new CartesianCoordinate(getX(), getY(), z);
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
