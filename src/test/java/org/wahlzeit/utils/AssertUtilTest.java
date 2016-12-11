package org.wahlzeit.utils;

import org.junit.Test;
import org.wahlzeit.exceptions.NullArgumentException;

public class AssertUtilTest {
    @Test(expected = NullArgumentException.class)
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
