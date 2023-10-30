package com.github.pioneeryi.lru;

// 双端链表节点
public class DeLinkNode {
    int key;
    int value;

    DeLinkNode pre;
    DeLinkNode next;

    public DeLinkNode() {
    }

    public DeLinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DeLinkNode(int key, int value, DeLinkNode pre, DeLinkNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
