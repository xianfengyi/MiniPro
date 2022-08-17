package com.github.pioneeryi;

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
