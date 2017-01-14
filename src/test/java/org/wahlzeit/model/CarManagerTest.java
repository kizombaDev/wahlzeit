package org.wahlzeit.model;


import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class CarManagerTest {
    @Test
    public void carManagerBuilderWithSubtypeTest() {
        CarManager carManager = CarManager.builder().createMake("Volkswagen", "Germany").createMake("Audi", "Germany", "Volkswagen").build();
        Assert.assertTrue(carManager.canCreateCarOfMake("Audi"));
    }

    @Test
    public void carManagerBuilderTest() {
        CarManager carManager = CarManager.builder().createMake("Volkswagen", "Germany").build();
        Assert.assertTrue(carManager.canCreateCarOfMake("Volkswagen"));

    }

    @Test
    public void createCarTest() {
        CarManager carManager = CarManager.builder().createMake("Audi", "Germany").build();
        Car a3 = carManager.createCar("Audi", "A3", Fuel.diesel, Color.CYAN, 1478.78);
        Assert.assertEquals("Audi", a3.getType().getMake());
        Assert.assertEquals("A3", a3.getModel());
        Assert.assertEquals(Fuel.diesel, a3.getFuel());
        Assert.assertEquals(Color.CYAN, a3.getColor());
        Assert.assertEquals(1478.78, a3.getWeight(), 0.01);
    }
}
