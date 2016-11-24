package org.wahlzeit.utils;

import org.junit.Assert;
import org.junit.Test;

public class DoubleUtilTest {
    @Test
    public void comparsionOfTwoEqualDoubles()
    {
        Assert.assertTrue(DoubleUtil.equals(5.0, 5.0));
    }

    @Test
    public void comparsionOfTwoDoublesWithDeltaLessThenEpsilon()
    {
        Assert.assertTrue(DoubleUtil.equals(5.000000000001, 5.000000000000));
    }

    @Test
    public void comparsionOfTwoDoublesWithDeltaMoreThenEpsilon()
    {
        Assert.assertFalse(DoubleUtil.equals(5.00001, 5.00000));
    }


}
