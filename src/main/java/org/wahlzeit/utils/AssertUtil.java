package org.wahlzeit.utils;

public  class AssertUtil {
    public static void assertIsParameterNull(Object underTest, String parameter)
    {
        if(underTest == null)
        {
            throw new IllegalStateException("The parameter " + parameter + " is null");
        }
    }
}
