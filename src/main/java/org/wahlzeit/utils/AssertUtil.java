package org.wahlzeit.utils;

public class AssertUtil {
    public static void assertIsParameterNotNull(Object underTest, String parameter)
    {
        if(underTest == null)
        {
            throw new IllegalArgumentException("The parameter " + parameter + " is null");
        }
    }
}
