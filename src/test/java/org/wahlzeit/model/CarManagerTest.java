package org.wahlzeit.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.awt.*;


/**
 * Test class for {@link CarManager}.
 */
public class CarManagerTest {
    private CarManager carManager;

    @Before
    public void setUp() {
        carManager = CarManager.builder().createMake("Volkswagen", "Germany").createMake("Audi", "Germany", "Volkswagen").build();
    }

    @Test
    public void carManagerBuilderWithSubtypeTest() {
        Assert.assertEquals("Volkswagen", carManager.getCarType("Audi").getBaseCarType().getMake());
    }

    @Test
    public void carManagerBuilderTest() {
        Assert.assertEquals("Volkswagen", carManager.getCarType("Volkswagen").getMake());
    }

    @Test
    public void createCarTest() {
        Car a3 = carManager.createCar("Audi", "A3", Fuel.diesel, Color.CYAN, 1478.78);
        Assert.assertEquals("Audi", a3.getType().getMake());
        Assert.assertEquals("A3", a3.getModel());
        Assert.assertEquals(Fuel.diesel, a3.getFuel());
        Assert.assertEquals(Color.CYAN, a3.getColor());
        Assert.assertEquals(1478.78, a3.getWeight(), 0.01);
    }

    @Test(expected = KeyAlreadyExistsException.class)
    public void carManagerBuilderBaseTypeIsMissingTest() {
        CarManager.builder().createMake("Audi", "Germany", "Volkswagen").build();
    }

    @Test
    public void getAllCarsTest() {
        carManager.createCar("Audi", "A3", Fuel.diesel, Color.CYAN, 1478.78);
        Assert.assertEquals("A3", carManager.getAllCars().get(0).getModel());
    }
}
