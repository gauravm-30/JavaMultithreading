package com.multithreading.PrintAlternateNumber.Approach3;

public class PrintAlternateNumberTestDrive {

    public static void main(String[] args) {
        // imp : lock Object should be same for both the thread
        final Object lock = new Object();
        final int maxNumber=50;
        SharedResource resource = new SharedResource(maxNumber,lock);
        Thread oddThread = new Thread(()-> resource.printOdd());
        Thread evenThread = new Thread(()-> resource.printEven());

        oddThread.start();
        evenThread.start();
//        try {
//            oddThread.join();
//            evenThread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

    }
}
