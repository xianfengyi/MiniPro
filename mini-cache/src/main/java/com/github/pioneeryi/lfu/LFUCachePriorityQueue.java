package com.github.pioneeryi.lfu;

import com.github.pioneeryi.ICache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// LFUCache, 最近使用频次最低的淘汰
public class LFUCachePriorityQueue implements ICache {

    private Map<Object, Node> content;
    private Queue<Node> queue;
    private int capacity;
    private int timeCnt;

    public LFUCachePriorityQueue(int capacity) {
        this.capacity = capacity;
        this.content = new HashMap<>();
        queue = new PriorityQueue<Node>();
    }

    @Override
    public int get(int key) {
        Node node = content.get(key);
        if (node == null) {
            return -1;
        }
        node.incrFre(timeCnt++);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        Node node = content.get(key);
        if (node != null) {
            node.value = value;
            node.incrFre(timeCnt++);
            return;
        }
        if (content.size() == capacity) {
            // 需要按照策略删除元素
            node = queue.poll();
            content.remove(node.key);
        }
        node = new Node(key, value, timeCnt++);
        queue.offer(node);
        content.put(key, node);
    }

    private static class Node implements Comparable<Node> {
        private int key;
        private int value;
        private int frequency;
        private int time;

        public Node(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }

        public void incrFre(int time) {
            this.frequency++;
            this.time = time;
        }

        @Override
        public int compareTo(Node target) {
            int fre = this.frequency - target.frequency;
            int res = fre != 0 ? fre : this.time - target.time;
            return -res;
        }
    }
}
