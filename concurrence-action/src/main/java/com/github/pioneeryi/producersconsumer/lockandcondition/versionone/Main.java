package com.github.pioneeryi.producersconsumer.lockandcondition.versionone;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock bufferLock = new ReentrantLock(true);
        Queue<Integer> queue = new LinkedList<>();

        Thread producerThread = new Thread(new Producer(queue, bufferLock));
        producerThread.setName("producerThread");

        Thread consumerThread1 = new Thread(new Consumer(queue, bufferLock));
        consumerThread1.setName("consumerThread1");

        Thread consumerThread2 = new Thread(new Consumer(queue, bufferLock));
        consumerThread2.setName("consumerThread2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}