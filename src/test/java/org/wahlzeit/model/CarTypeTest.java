package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Test class for {@link CarType}.
 */
public class CarTypeTest {

    private CarType audi;
    private CarType volkswagen;

    @Before
    public void setUp() {
        volkswagen = new CarType("Volkswagen", "Germany");
        audi = new CarType(volkswagen, "Audi", "Germany");
    }

    @Test
    public void getMakeTest() {
        Assert.assertEquals("Audi", audi.getMake());
    }

    @Test
    public void getCountyTest() {
        Assert.assertEquals("Germany", audi.getCounty());
    }

    @Test
    public void getBaseCarTypeTest() {
        Assert.assertSame(volkswagen, audi.getBaseCarType());
    }

    @Test
    public void createInstanceTest() {
        Car a1 = audi.createInstance("A1", Fuel.diesel, Color.BLUE, 1400);
        Assert.assertEquals("Audi", a1.getType().getMake());
        Assert.assertEquals("A1", a1.getModel());
        Assert.assertEquals(Fuel.diesel, a1.getFuel());
        Assert.assertEquals(Color.BLUE, a1.getColor());
        Assert.assertEquals(1400, a1.getWeight(), 0.1);
    }

    @Test
    public void callIsSubtypeWithNullTest() {
        Assert.assertFalse(audi.isSubtype(null));
    }

    @Test
    public void callIsSubtypeWithRandomCarTypeTest() {
        Assert.assertFalse(audi.isSubtype(new CarType("Mercedes", "Germany")));
    }

    @Test
    public void callIsSubtypeWithSameCarTypeTest() {
        Assert.assertFalse(audi.isSubtype(audi));
    }

    @Test
    public void callIsSubtypeWithSubCarTypeTest() {
        Assert.assertTrue(audi.isSubtype(volkswagen));
    }
}
