package com.multithreading.PrintAlternateNumber.Approach3;

public class SharedResource {
    private final int maxNumber;
    private final Object lock;
    //This current number need to be shared between both methods
    private int currentNumber = 1;


    public SharedResource(int maxNumber, Object lock) {
        this.maxNumber = maxNumber;
        this.lock = lock;
    }

    public void printOdd() {
        synchronized (lock) {
            System.out.println("Odd Thread Execution Starts");
            while (currentNumber <= maxNumber) {
                if (currentNumber % 2 == 1) {
                    System.out.println("Odd: " + currentNumber);
                    currentNumber++;
                    lock.notify();  //it will loop because notify doesn't leave the lock immediately
                } else {
                    try {
                        System.out.println("Odd Thread Execution Waiting");
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
            System.out.println("Even Thread Execution Starts");
            while (currentNumber <= maxNumber) {
                if (currentNumber % 2 == 0) {
                    System.out.println("Even: " + currentNumber);
                    currentNumber++;
                    lock.notify(); //it will loop because notify doesn't leave the lock immediately
                } else {
                    try {
                        System.out.println("Even Thread Execution Waiting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
