package com.multithreading.ProducerConsumerProblem.Approach2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTestDrive {

    public static void main(String[] args) {
        BlockingQueue<Integer> integerBuffer = new ArrayBlockingQueue<>(10);
        Runnable producer = new ProducerThread(integerBuffer);
        Runnable consumer = new ConsumerThread(integerBuffer);
        Thread t1 = new Thread(producer,"Producer Thread");
        Thread t2 = new Thread(consumer,"Consumer Thread");
        t1.start();
        t2.start();
    }
}
