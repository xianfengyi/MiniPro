package com.github.pioneeryi;

public interface ICache<K, V> {

    /**
     * 获取缓存中的值.
     *
     * @param key 缓存 KEY
     * @return 缓存值
     */
    V get(K key);

    /**
     * 向缓存中插入值.
     *
     * <p>如果不存在，就新增，如果存在就更新，当缓存满了，根据相应的策略删除，比如 LRU，LFU</p>
     *
     * @param key   缓存 KEY
     * @param value 缓存值
     */
    void put(K key, V value);

}
