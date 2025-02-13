package com.multithreading.ProducerConsumerProblem.Approach2;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable{
    private final BlockingQueue<Integer> integerBuffer;

    public ConsumerThread(BlockingQueue<Integer> integerBuffer) {
        this.integerBuffer = integerBuffer;
    }

    @Override
    public void run() {
            consumeDataInBlockingQueue();
    }

    private void consumeDataInBlockingQueue(){
        while(true){
            try {
                int integerFromBuffer = integerBuffer.take();
                System.out.println("Consumed " + integerFromBuffer);
            }catch (InterruptedException ex){
                ex.fillInStackTrace();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
