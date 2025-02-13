package com.multithreading.ProducerConsumerProblem.Approach2;

import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable{
    private final BlockingQueue<Integer> integerBuffer;

    public ProducerThread(BlockingQueue<Integer> integerBuffer) {
        this.integerBuffer = integerBuffer;
    }

    @Override
    public void run() {
        try {
            produceDataInBlockingQueue();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void produceDataInBlockingQueue() throws InterruptedException {
        for (int i = 0; i <=10; i++) {
            integerBuffer.put(i);
            System.out.println("Produced " + i);
        }
    }
}
