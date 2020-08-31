package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private Emission em;
    Arguments arg;
    @Before
    public void setUp() {
        em = new Emission();
        arg = new Arguments();
        arg.setOutputUnit("kg");
        arg.setDistanceUnit("m");
        arg.setDistance(14500.0);
        arg.setTransportationMethod("train");
    }
    @Test
    public void testUnit() {
        Assert.assertEquals("kg", em.determineOutputUnit(arg));
    }

    @Test
    public void testEmissionRate() {
        Assert.assertEquals(142.0, em.fetchEmissionRate("small-diesel-car"), 0.0);
    }

    @Test
    public void testCalculation() {
        Assert.assertEquals(0.1, em.calculateEmission(6, arg), 0.0);
    }
}
