package com.github.pioneeryi;

import java.util.Arrays;
import java.util.Objects;

/**
 * HashTable.
 *
 * @author yixianfeng
 * @since 2022/8/17 17:24
 */
public class HashTable<K, V> {

    private static final int DEFAULT_SIZE = 10;

    // store the data
    private HashNode[] buckets;

    // current capacity of buckets
    private int capacity;

    // current size of buckets
    private int size;

    public HashTable() {
        capacity = DEFAULT_SIZE;
        size = 0;
        buckets = new HashNode[DEFAULT_SIZE];
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = buckets[index];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int index = hash(key);
        HashNode node = buckets[index];

        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        // head insert
        size++;
        HashNode head = buckets[index];
        HashNode newHead = new HashNode(key, value);
        newHead.next = head;
        buckets[index] = newHead;

        checkAndExpandCapacity();
    }

    private void checkAndExpandCapacity() {
        if (1.0 * size / capacity < 0.7) {
            return;
        }

        HashNode[] temp = Arrays.copyOf(buckets, buckets.length);

        capacity = capacity * 2;
        buckets = new HashNode[capacity];
        size = 0;
        for (int i = 0; i < temp.length; i++) {
            HashNode<K, V> node = temp[i];
            while (node != null) {
                add(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);

        HashNode dummyHead = new HashNode();
        HashNode dummyNode = dummyHead;
        HashNode node = buckets[index];
        dummyNode.next = node;

        while (node != null) {
            if (node.key == key) {
                dummyNode.next = node.next;
                return;
            }
            node = node.next;
            dummyNode = dummyNode.next;
        }
        buckets[index] = dummyHead.next;
    }

    public int size() {
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return Objects.hashCode(key) % DEFAULT_SIZE;
    }
}
