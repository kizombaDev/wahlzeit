package org.wahlzeit.model;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ValueTypeCache<K> {
    protected ConcurrentMap<K, K> cache = new ConcurrentHashMap<>();

    public K putIfAbsent(K value) {
        K result = cache.get(value);
        if (result == null) {
            cache.putIfAbsent(value, value);
            result = cache.get(value);
        }

        return result;
    }
}
