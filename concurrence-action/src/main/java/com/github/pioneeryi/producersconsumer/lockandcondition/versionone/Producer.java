package com.github.pioneeryi.producersconsumer.lockandcondition.versionone;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity = 5;

    private Lock lock;

    public Producer(Queue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (queue.size() == capacity) {
                    continue;
                }
                int number = new Random().nextInt();
                queue.offer(number);
                System.out.println(Thread.currentThread().getName() +"produce: " + number);

                Thread.sleep(500);
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
