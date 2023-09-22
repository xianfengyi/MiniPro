package com.github.pioneeryi.producersconsumer.lockandcondition.versiontwo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Queue<Integer> queue = new LinkedList<>();

        Thread producerThread = new Thread(new Producer(queue, lock));
        producerThread.setName("producerThread");

        Thread consumerThread1 = new Thread(new Consumer(queue, lock));
        consumerThread1.setName("consumerThread1");

        Thread consumerThread2 = new Thread(new Consumer(queue, lock));
        consumerThread2.setName("consumerThread2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}