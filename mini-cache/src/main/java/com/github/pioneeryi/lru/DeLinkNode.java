package com.github.pioneeryi.lru;

// 双端链表节点
public class DeLinkNode {
    Object key;
    Object value;

    DeLinkNode pre;
    DeLinkNode next;

    public DeLinkNode() {
    }

    public DeLinkNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public DeLinkNode(Object key, Object value, DeLinkNode pre, DeLinkNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
