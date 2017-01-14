package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.exceptions.NullArgumentException;
import org.wahlzeit.exceptions.PhotoComponentException;

import java.awt.*;
import java.security.InvalidParameterException;

/**
 * Test class for {@link Car}.
 */
public class CarTest {

    private CarType audi;
    private Car car;

    @Test
    public void getTypeTest() {
        Car a1 = new Car(audi, "A1", Fuel.petrol, Color.black, 1234.12);

        Assert.assertSame(audi, a1.getType());
    }

    @Before
    public void setUp() {
        audi = new CarType("Audi", "Germany");
        car = new Car(new CarType("Audi", "Germany"), "A1", Fuel.petrol, Color.black, 1234.12);
    }

    @Test
    public void modelPropertyTest() {
        Assert.assertEquals("A1", car.getModel());
    }

    @Test
    public void fuelPropertyTest() throws PhotoComponentException {
        Assert.assertEquals(Fuel.petrol, car.getFuel());
    }

    @Test
    public void colorPropertyTest() throws PhotoComponentException {
        Assert.assertEquals(Color.black, car.getColor());
    }

    @Test
    public void weightPropertyTest() {
        Assert.assertEquals(1234.12, car.getWeight(), 0.001);
    }

    @Test(expected = NullArgumentException.class)
    public void createCarWithInvalidCarTypeTest() {
        new Car(null, "A3", Fuel.diesel, Color.black, 1478.1);
    }

    @Test(expected = NullArgumentException.class)
    public void createCarWithInvalidModelTest() {
        new Car(new CarType("Audi", "Germany"), "", Fuel.diesel, Color.black, 1478.1);
    }

    @Test(expected = NullArgumentException.class)
    public void createCarWithInvalidFuelTest() {
        new Car(new CarType("Audi", "Germany"), "A3", null, Color.black, 1478.1);
    }

    @Test(expected = NullArgumentException.class)
    public void createCarWithInvalidColorTest() {
        new Car(new CarType("Audi", "Germany"), "A3", Fuel.diesel, null, 1478.1);
    }

    @Test(expected = InvalidParameterException.class)
    public void createCarWithInvalidWeightTest() {
        new Car(new CarType("Audi", "Germany"), "A3", Fuel.diesel, Color.black, 0);
    }
}
