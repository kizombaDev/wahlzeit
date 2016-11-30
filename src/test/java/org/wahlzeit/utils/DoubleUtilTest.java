package org.wahlzeit.utils;

import org.junit.Assert;
import org.junit.Test;

public class DoubleUtilTest {
    @Test
    public void comparisonOfTwoEqualDoubles() {
        Assert.assertTrue(DoubleUtil.equals(5.0, 5.0));
    }

    @Test
    public void comparisonOfTwoDoublesWithDeltaLessThenEpsilon() {
        Assert.assertTrue(DoubleUtil.equals(5.000000000001, 5.000000000000));
    }

    @Test
    public void comparisonOfTwoDoublesWithDeltaMoreThenEpsilon() {
        Assert.assertFalse(DoubleUtil.equals(5.00001, 5.00000));
    }
}
