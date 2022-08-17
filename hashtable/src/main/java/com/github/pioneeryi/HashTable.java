package com.github.pioneeryi;

import java.util.Objects;

/**
 * HashTable.
 *
 * @author yixianfeng
 * @since 2022/8/17 17:24
 */
public class HashTable<K, V> {

    private static final int DEFAULT_SIZE = 5;
    private HashNode[] buckets = new HashNode[DEFAULT_SIZE];

    public V get(K key) {
        int index = hash(key);
        HashNode<K,V> node = buckets[index];
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
        HashNode head = buckets[index];
        HashNode newHead = new HashNode(key, value);
        newHead.next = head;
        buckets[index] = newHead;
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

    private int hash(K key) {
        return Objects.hashCode(key) % DEFAULT_SIZE;
    }
}
