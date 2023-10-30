package com.github.pioneeryi;

public interface ICache {

    /**
     * 获取缓存中的值.
     *
     * @param key 缓存 KEY
     * @return 缓存值
     */
    int get(int key);

    /**
     * 向缓存中插入值.
     *
     * <p>如果不存在，就新增，如果存在就更新，当缓存满了，根据相应的策略删除，比如 LRU，LFU</p>
     *
     * @param key   缓存 KEY
     * @param value 缓存值
     */
    void put(int key, int value);

}
