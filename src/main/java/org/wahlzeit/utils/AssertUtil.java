package org.wahlzeit.utils;

import org.wahlzeit.exceptions.NullArgumentException;

public class AssertUtil {
    public static void assertParameterIsNotNull(Object underTest, String parameterName)
    {
        if(underTest == null)
        {
            throw new NullArgumentException(parameterName);
        }
    }

    public static void assertParameterIsNotNullOrEmpty(String underTest, String parameterName) {
        if (StringUtil.isNullOrEmptyString(underTest)) {
            throw new NullArgumentException(parameterName);
        }
    }
}
