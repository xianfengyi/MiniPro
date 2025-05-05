package com.github.pioneeryi.lfu;

import com.github.pioneeryi.ICache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCacheCustom implements ICache {
    private int capacity;
    // key: node value, value: node
    private Map<Integer, Node> content;
    // key：frequency, value: node list
    private Map<Integer, List<Node>> sameFre;
    // 最小频次值
    private int minFre = Integer.MAX_VALUE;

    public LFUCacheCustom(int capacity) {
        this.capacity = capacity;
        this.content = new HashMap<>();
        this.sameFre = new HashMap<>();
    }

    @Override
    public int get(int key) {
        Node node = content.get(key);
        if (node == null) {
            return -1;
        }
        updateNodeFrequency(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        Node node = content.get(key);
        if (node != null) {
            // update node
            node.value = value;
            updateNodeFrequency(node);
            return;
        }
        if (content.size() == capacity) {
            // 删除频次最低切最久未使用的
            deleteLastFreNode();
        }
        node = new Node(key, value);
        updateNodeFrequency(node);
        content.put(key, node);
    }

    private void deleteLastFreNode() {
        List<Node> sameList = sameFre.get(minFre);
        int freCount = minFre;
        while (sameList.isEmpty() && (freCount - minFre) <= sameFre.size()) {
            freCount++;
            sameList = sameFre.get(freCount);
        }
        Node target = sameList.get(sameList.size() - 1);
        content.remove(target.key);
        sameList.remove(target);
        if (sameList.isEmpty()) {
            minFre++;
        }
    }

    private void updateNodeFrequency(Node node) {
        // 先从原来的频次队列删除
        List pre = sameFre.get(node.frequency);
        if (pre != null && !pre.isEmpty()) {
            pre.remove(node);
        }
        // 再加入新的频次队列里
        int newFre = node.incrFre();
        if (newFre < minFre) {
            minFre = newFre;
        }
        List sameFreList = sameFre.getOrDefault(newFre, new ArrayList<>());
        // 采用头插法
        sameFreList.add(0, node);
        sameFre.put(newFre, sameFreList);
    }

    private static class Node<K, V> {
        private int key;
        private int value;
        private int frequency;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int incrFre() {
            this.frequency++;
            return this.frequency;
        }
    }
}
