package com.multithreading.PrintAlternateNumber.Approach2;

public class PrintOddNumberThread implements Runnable{

    private final int maxNumber;
    private final Object lock;
    private final SharedValue sharedValue;

    public PrintOddNumberThread(int maxNumber, Object lock, SharedValue sharedValue) {
        this.maxNumber = maxNumber;
        this.lock = lock;
        this.sharedValue = sharedValue;
    }

    @Override
    public void run() {
        try {
            printOddNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printOddNumber() throws InterruptedException {
            synchronized (lock){
                while(sharedValue.getValue()<=maxNumber){
                int i = sharedValue.getValue();
                System.out.println("Odd Thread Execution Starts");
                if(i%2!=0){
                    System.out.println(Thread.currentThread().getName() + " Odd: " +i);
                    sharedValue.setValue(i+1);
                    System.out.println("After updation from odd " + sharedValue.getValue());
                    lock.notify();
                }else {
                    System.out.println("Odd Thread Execution Waiting");
                    lock.wait();
                }
            }

        }
    }


}
