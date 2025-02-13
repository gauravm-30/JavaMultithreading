package com.multithreading.ThreadGroup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadGroupTestDrive {
    public static void main(String[] args) {
        //creating the thread group
        ThreadGroup parentGroup = new ThreadGroup("Parent Group");
        ThreadGroup childGroup = new ThreadGroup(parentGroup,"childGroup");
        Thread t1 = new Thread(parentGroup,()-> System.out.println("Hello Thread of Parent Group"));
        Thread t2 = new Thread(childGroup,()-> System.out.println("Hello Thread of Child Group"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);


    }
}
