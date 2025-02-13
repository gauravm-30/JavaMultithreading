package com.multithreading.PrintAlternateNumber.Approach2;

import com.multithreading.PrintAlternateNumber.Approach3.SharedResource;

public class PrintAlternateNumberTestDrive {

    public static void main(String[] args) throws InterruptedException {
        // imp : lock Object should be same for both the thread
        final Object lock = new Object();
        final int maxNumber=50;
        final SharedValue sharedValue = new SharedValue(1);
        Runnable printEvenNumberThread = new PrintEvenNumberThread(maxNumber,lock,sharedValue);
        Runnable printOddNumberThread = new PrintOddNumberThread(maxNumber,lock,sharedValue);
        Thread t1  = new Thread(printEvenNumberThread,"Even Thread");
        Thread t2  = new Thread(printOddNumberThread,"Odd Thread");
        t1.start();
        t2.start();
    }
}
