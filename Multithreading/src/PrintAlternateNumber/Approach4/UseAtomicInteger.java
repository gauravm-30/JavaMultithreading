package com.multithreading.PrintAlternateNumber.Approach4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UseAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
         final Object LOCK = new Object();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable printOdd = ()-> {
            synchronized (LOCK){
                while (atomicInteger.get()<=50){
                    if(atomicInteger.get()%2==1){
                        System.out.println("Odd" + atomicInteger.get());
                        atomicInteger.getAndIncrement();
                        LOCK.notify();
                    }else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Runnable printEven = ()-> {
            synchronized (LOCK){
                while (atomicInteger.get()<=50){
                    if(atomicInteger.get()%2==0){
                        System.out.println("Even" + atomicInteger.get());
                        atomicInteger.getAndIncrement();
                        LOCK.notify();
                    }else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        executor.execute(printOdd);
        executor.execute(printEven);

    }
}
