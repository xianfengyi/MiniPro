package com.github.pioneeryi;

/**
 * HashNode.
 *
 * @author yixianfeng
 * @since 2022/8/17 17:29
 */
public class HashNode<K, V> {

    K key;
    V value;
    HashNode next;

    public HashNode() {
    }

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
