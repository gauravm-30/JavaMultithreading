package Threads;

public class CustomThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Inside Custom Thread: " + i);
    }
  }
}
