package org.wahlzeit.utils;

import org.junit.Test;

public class AssertUtilTest {
    @Test(expected =  IllegalArgumentException.class)
    public void passNullToAssertIsParameterNull()
    {
        AssertUtil.assertParameterIsNotNull(null, "");
    }

    @Test
    public void passNotNullToAssertIsParameterNull()
    {
        AssertUtil.assertParameterIsNotNull("", "");
    }
}
