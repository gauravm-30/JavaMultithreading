package WaitNotifyNotifyAll;

public class ThreadWaitNotifyDemo {
  private static final Object LOCK = new Object();

  public static void main(String[] args) throws InterruptedException {

    Thread waitingThread =
        new Thread(
            () -> {
              // remember that at a time only one thread can acquire the lock if they are working on
              // same lock
              synchronized (LOCK) {
                System.out.println("Thread is going to wait : " + Thread.currentThread().getName());
                try {
                  LOCK.wait();
                  System.out.println("Thread is notified : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
              }
            });
    waitingThread.start();

    // main thread running
    // simulate some processing
    // if we don't simulate some processing the either main thread or other thread, anyone of them
    // can acquire lock on it
    // And suppose below thread runs first and then the waiting thread runs  then it will make the
    // waiting thread wait forever
    Thread.sleep(2000);
    synchronized (LOCK) {
      System.out.println("Thread is going to notify : " + Thread.currentThread().getName());
      LOCK.notify();
      System.out.println("Sent notification to wake up the waiting thread");
    }
  }
}
