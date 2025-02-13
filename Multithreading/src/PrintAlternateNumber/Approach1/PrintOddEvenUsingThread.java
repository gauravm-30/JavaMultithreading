package com.multithreading.PrintAlternateNumber.Approach1;


public class PrintOddEvenUsingThread {
    public static void printOddEven(){
        SharedResource resource = new SharedResource();
        Thread oddThread = new Thread(() -> {
            resource.printOdd();
        });
        Thread evenThread = new Thread(() -> {
            resource.printEven();
        });

        oddThread.start();
        evenThread.start();
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class SharedResource {
    //These both are shared resource
    private int currentNumber = 1;
    private final Object lock = new Object();
    public void printOdd() {
        synchronized (lock) {
            while (currentNumber <= 10) {
                if (currentNumber % 2 == 1) {
                    System.out.println("Odd: " + currentNumber);
                    currentNumber++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
    public void printEven() {
        synchronized (lock) {
            while (currentNumber <= 10) {
                if (currentNumber % 2 == 0) {
                    System.out.println("Even: " + currentNumber);
                    currentNumber++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
