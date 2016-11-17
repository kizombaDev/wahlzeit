package org.wahlzeit.utils;

import org.junit.Test;

public class AssertUtilTest {
    @Test(expected =  IllegalArgumentException.class)
    public void PassNullToAssertIsParameterNull()
    {
        AssertUtil.assertIsParameterNull(null, "");
    }

    @Test
    public void PassNotNullToAssertIsParameterNull()
    {
        AssertUtil.assertIsParameterNull("", "");
    }
}
