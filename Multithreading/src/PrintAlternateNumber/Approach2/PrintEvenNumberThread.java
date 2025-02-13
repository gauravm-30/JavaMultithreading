package com.multithreading.PrintAlternateNumber.Approach2;

public class PrintEvenNumberThread implements Runnable{

    private final int maxNumber;
    private final Object lock;
    private final SharedValue sharedValue;

    public PrintEvenNumberThread(int maxNumber, Object lock, SharedValue sharedValue) {
        this.maxNumber = maxNumber;
        this.lock = lock;
        this.sharedValue = sharedValue;
    }

    @Override
    public void run() {
        try {
            printEvenNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void printEvenNumber() throws InterruptedException {
            //we can also take lock on shared value
            synchronized (lock){
                System.out.println("Even Thread Execution Starts");
                while(sharedValue.getValue()<=maxNumber){
                int i = sharedValue.getValue();
                if(i%2==0) {
                    System.out.println(Thread.currentThread().getName() + " Even " + i);
                    sharedValue.setValue(i + 1);
                    System.out.println("After updation from even " +sharedValue.getValue());
                    lock.notify();
                }else {
                    System.out.println("Even Thread Execution Waiting");
                    lock.wait();
                }

            }
        }
    }


}
