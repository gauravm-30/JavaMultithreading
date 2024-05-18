package WaitNotifyNotifyAll;

public class MovieTotalEarnings {

  private static final Object LOCK = new Object();
  static int total = 0;

  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            () -> {
              synchronized (LOCK) {
                System.out.println(
                    "Calculating the total earning " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                  total = total + 100;
                }
                LOCK.notify();
              }
            });
    t1.start();
    synchronized (LOCK) {
      System.out.println("Main thread is waiting for total earnings : " + total);
      LOCK.wait();
      System.out.println("Main thread total earnings : " + total);
    }
  }
}
