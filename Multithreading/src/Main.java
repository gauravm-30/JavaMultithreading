public class Main {
  // Thread Based Multitasking
  // Allows parts of same program to run concurrently on  the computer

  // Threads vs Process
  // Two threads share the same memory address space
  // Context switching between threads is usually less expensive than between processes;
  // The cost of communication between two threads is relatively low

  // Thread
  // A thread is a independent sequential path of execution within a program.

  // At runtime , thread in a program exist in a common memory space and can , therefore shared both
  // data and code
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}
