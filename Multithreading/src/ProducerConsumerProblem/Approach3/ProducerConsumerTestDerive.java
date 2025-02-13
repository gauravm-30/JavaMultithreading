package com.multithreading.ProducerConsumerProblem.Approach3;

import java.util.concurrent.ForkJoinWorkerThread;

public class ProducerConsumerTestDerive {
    public static void main(String[] args) {
        Thread t1 = new CustomThread();
        t1.start();

        Thread t2 = new CustomThread();
    }
}
