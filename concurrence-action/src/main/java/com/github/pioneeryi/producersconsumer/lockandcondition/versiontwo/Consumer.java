package com.github.pioneeryi.producersconsumer.lockandcondition.versiontwo;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private Queue<Integer> queue;

    private Lock lock;

    public Consumer(Queue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (queue.isEmpty()) {
                    continue;
                }
                int number = queue.poll();
                System.out.println(Thread.currentThread().getName() +"consume: " + number);
                Thread.sleep(500);
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
