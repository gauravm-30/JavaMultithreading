package ThreadLocal;

public class ThreadLocalTestDrive {
    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        System.out.println("Thread Local");

        // Create two threads that modify the ThreadLocal variable
         Thread thread1 = new Thread(new Task(), "Thread-1");
         Thread thread2 = new Thread(new Task(), "Thread-2");
         thread1.start();
         thread2.start();
    }

     static class Task implements Runnable {
        @Override public void run() {
        // Get the initial value
         Integer initialValue = integerThreadLocal.get();
         System.out.println(Thread.currentThread().getName() + " initial value: " + initialValue);
         // Set a new value
            integerThreadLocal.set((int) (Math.random() * 100));
         Integer newValue = integerThreadLocal.get();
         System.out.println(Thread.currentThread().getName() + " new value: " + newValue);
    }
    }
}
