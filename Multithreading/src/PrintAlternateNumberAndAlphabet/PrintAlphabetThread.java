package com.multithreading.PrintAlternateNumberAndAlphabet;

public class PrintAlphabetThread implements Runnable{
    private final Object lock;

    public PrintAlphabetThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
            synchronized (lock){
                System.out.println("PrintAlphabet" + i);
                try {
                    lock.wait();  // Now it will hold  here
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
