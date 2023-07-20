package com.github.pioneeryi.producersconsumer.waitnotify;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity = 5;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
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
                queue.offer(number);
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
