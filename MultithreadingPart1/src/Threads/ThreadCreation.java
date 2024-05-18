package Threads;

// A thread in Java is represented by an Object of the thread class.
// We can create the threads in one of two ways :
// implementing the runnnable interface
// Extending the Thread class.
// Using runnable interface is better because are not restricted there.
public class ThreadCreation {
  public static void main(String[] args) {
    System.out.println("Main thread Starting");

    // Creating thread by extending class
    Thread t1 = new CustomThread();
    t1.start();

    // by implementing runnable interface
    Runnable r1 =
        new Runnable() {
          @Override
          public void run() {
            for (int i = 0; i < 5; i++) {
              System.out.println("i = " + i);
            }
          }
        };
    Thread t2 = new Thread(r1);
    // Now when start() call the run() method , it immediately returns the control to next line
    t2.start();
    System.out.println("Main thread Exiting");
  }
}
