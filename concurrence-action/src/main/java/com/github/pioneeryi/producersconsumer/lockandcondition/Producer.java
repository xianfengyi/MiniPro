package com.github.pioneeryi.producersconsumer.lockandcondition;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity;

    private Lock lock;
    private Condition condition;

    public Producer(Queue<Integer> queue, int capacity, Lock lock, Condition condition) {
        this.queue = queue;
        this.capacity = capacity;
        this.lock = lock;
        this.condition = condition;
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
