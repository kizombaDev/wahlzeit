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

    @Test(expected = NullArgumentException.class)
    public void passNullToAssertParameterIsNotNullOrEmpty() {
        AssertUtil.assertParameterIsNotNullOrEmpty(null, "");
    }

    @Test(expected = NullArgumentException.class)
    public void passEmptyStringToAssertParameterIsNotNullOrEmpty() {
        AssertUtil.assertParameterIsNotNullOrEmpty("", "");
    }

    @Test
    public void passFooToAssertParameterIsNotNullOrEmpty() {
        AssertUtil.assertParameterIsNotNullOrEmpty("Foo", "");
    }
}
