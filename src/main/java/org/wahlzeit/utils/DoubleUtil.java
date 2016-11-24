package org.wahlzeit.utils;

public class DoubleUtil {
    private static double EPSILON = 0.0000001;
    public static boolean equals(double a, double b)
    {
        if (a==b){
            return true;
        }
        return Math.abs(a - b) < EPSILON;
    }
}
