package com.github.pioneeryi.producersconsumer.waitnotify;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int number = new Random().nextInt();
                System.out.println("produce: " + number);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.notifyAll();
            }

        }
    }
}
