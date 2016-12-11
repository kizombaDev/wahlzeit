package org.wahlzeit.utils;

import org.wahlzeit.exceptions.NullArgumentException;

public class AssertUtil {
    public static void assertParameterIsNotNull(Object underTest, String parameter)
    {
        if(underTest == null)
        {
            throw new NullArgumentException("parameter");
        }
    }
}
