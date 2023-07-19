package com.github.pioneeryi.producersconsumer.lockandcondition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private Queue<Integer> queue;

    private Lock lock = new ReentrantLock();
    private Condition condition;

    public Consumer(Queue<Integer> queue, Lock lock, Condition condition) {
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int number = queue.poll();
                System.out.println("consume: " + number);
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
