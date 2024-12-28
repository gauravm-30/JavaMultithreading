package WaitNotifyNotifyAll;

public class EvenOddPrintBy2Threads implements Runnable {
  static final Object LOCK = new Object();
  static int count = 1; // want to print from 1 to 10

  public static void main(String[] args) {
    Runnable r1 = new EvenOddPrintBy2Threads();
    Runnable r2 = new EvenOddPrintBy2Threads();
    new Thread(r1, "even").start();
    new Thread(r2, "odd").start();
  }

  @Override
  public void run() {
    while (count <= 10) {

      if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
        synchronized (LOCK) {
          System.out.println("Thread Name = " + Thread.currentThread().getName() + count);
          count++;
          try {
            LOCK.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
      if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
        synchronized (LOCK) {
          System.out.println("Thread Name = " + Thread.currentThread().getName() + count);
          count++;
          LOCK.notify();
        }
      }
    }
  }
}
