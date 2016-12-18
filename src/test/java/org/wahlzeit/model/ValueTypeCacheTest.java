package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class ValueTypeCacheTest {
    @Test
    public void twoSameValuesTest() {
        ValueTypeCache<ValueSample> cache = new ValueTypeCache<>();
        ValueSample a = cache.putIfAbsent(new ValueSample(42));
        ValueSample b = cache.putIfAbsent(new ValueSample(42));

        Assert.assertSame(a, b);
    }

    @Test
    public void twoDifferentValuesTest() {
        ValueTypeCache<ValueSample> cache = new ValueTypeCache<>();
        ValueSample a = cache.putIfAbsent(new ValueSample(42));
        ValueSample b = cache.putIfAbsent(new ValueSample(99));

        Assert.assertNotSame(a, b);
    }

    private class ValueSample {
        private final Integer value;

        public ValueSample(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return new Integer(value);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (o == this) {
                return true;
            }

            if (o instanceof ValueSample) {
                ValueSample a = (ValueSample) o;
                return a.value.equals(this.value);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}
