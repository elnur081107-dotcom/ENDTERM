package org.example.endterm.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarCache {

    private static CarCache instance;

    private final Map<String, Object> cache;

    private CarCache() {
        cache = new ConcurrentHashMap<>();
    }

    public static synchronized CarCache getInstance() {
        if (instance == null) {
            instance = new CarCache();
        }
        return instance;
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public void clear() {
        cache.clear();
    }

    public void remove(String key) {
        cache.remove(key);
    }
}

