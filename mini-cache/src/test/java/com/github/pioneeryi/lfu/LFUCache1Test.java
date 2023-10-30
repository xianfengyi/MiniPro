package com.github.pioneeryi.lfu;

import org.junit.Assert;
import org.junit.Test;

public class LFUCache1Test {

    @Test
    public void testLRUCache() {
        LFUCache1 cache = new LFUCache1(2 /* capacity (缓存容量) */);

        cache.put(1, 1);
        cache.put(2, 2);
        Object res = cache.get(1);
        // 返回 1
        Assert.assertEquals(1, res);

        cache.put(3, 3);
        // 去除 key 2
        res = cache.get(2);
        // 返回 -1 (未找到key 2)
        Assert.assertEquals(-1, res);

        res = cache.get(3);
        // 返回 3
        Assert.assertEquals(3, res);

        cache.put(4, 4);    // 去除 key 1
        res = cache.get(1);
        // 返回 -1 (未找到 key 1)
        Assert.assertEquals(-1, res);

        res = cache.get(3);
        // 返回 3
        Assert.assertEquals(3, res);

        res = cache.get(4);
        // 返回 4
        Assert.assertEquals(4, res);
    }
}