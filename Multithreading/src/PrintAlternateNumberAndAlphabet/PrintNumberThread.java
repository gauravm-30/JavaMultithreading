package com.multithreading.PrintAlternateNumberAndAlphabet;

public class PrintNumberThread implements Runnable {

    private final Object lock;

    public PrintNumberThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
            for (int i = 1; i < 26; i++) {
                   synchronized (lock){
                       System.out.println(i);
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
            }

    }
}
