package com.github.pioneeryi.lru;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testGet_CacheNoValue() {
        LRUCache cache = new LRUCache(5);
        Object res = cache.get(2);
        Assert.assertEquals(-1, res);
    }

    @Test
    public void testPut_CacheNotFull() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        Assert.assertEquals(1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
    }

    @Test
    public void testPut_CacheNotFull_Update() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 33);
        Assert.assertEquals(1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(33, cache.get(3));
    }

    @Test
    public void testPut_CacheFull() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }
}