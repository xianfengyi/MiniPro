package com.github.pioneeryi;

/**
 * HashNode.
 *
 * @author yixianfeng
 * @since 2022/8/17 17:29
 */
public class HashNode {

    int key;
    int value;
    HashNode next;

    public HashNode() {
    }

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
