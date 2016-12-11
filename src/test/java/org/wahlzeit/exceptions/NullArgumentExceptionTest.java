package org.wahlzeit.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class NullArgumentExceptionTest {

    @Test
    public void messageTest() {
        Exception e = new NullArgumentException("index");
        Assert.assertEquals("index must not be null.", e.getMessage());
    }

    @Test
    public void getParameterTest() {
        NullArgumentException e = new NullArgumentException("index");
        Assert.assertEquals("index", e.getParameter());
    }

    @Test(expected = NullArgumentException.class)
    public void passNullTest() {
        new NullArgumentException(null);
    }
}
