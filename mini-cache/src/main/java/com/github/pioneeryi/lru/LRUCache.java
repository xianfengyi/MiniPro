package com.github.pioneeryi.lru;

import com.github.pioneeryi.ICache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRUCache. 最近最久未使用淘汰
 */
public class LRUCache implements ICache {

    private int capacity;
    private DeLinkNode head;
    private DeLinkNode tail;
    private Map<Object, DeLinkNode> content;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.content = new ConcurrentHashMap<>();
        head = new DeLinkNode();
        tail = new DeLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    @Override
    public int get(int key) {
        DeLinkNode node = content.get(key);
        if (node == null) {
            return -1;
        }
        moveToListHead(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        DeLinkNode node = content.get(key);
        if (node != null) {
            node.value = value;
            moveToListHead(node);
            return;
        }
        if (content.size() == capacity) {
            deleteListTail();
        }
        node = new DeLinkNode(key, value);
        headInsert(node);
        content.put(key, node);
    }

    private void headInsert(DeLinkNode node) {
        DeLinkNode next = this.head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    private void moveToListHead(DeLinkNode node) {
        // 首先删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // 然后将节点插入到头上
        headInsert(node);
    }

    private void deleteListTail() {
        if (tail.pre == head) {
            return;
        }
        DeLinkNode node = tail.pre;
        content.remove(node.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }
}
