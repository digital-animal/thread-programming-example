package com.zahid.basic.racecondition;

public class RaceConditionTest2 {
    public static void main(String[] args) {
        Thread.currentThread().setName("Main Thread");

        MyRunnable myRunnable1 = new MyRunnable(); 
        MyRunnable myRunnable2 = new MyRunnable(); 

        // separate runnable object passed to each thread
        Thread t1 = new Thread(myRunnable1, "Thread 1");
        Thread t2 = new Thread(myRunnable2, "Thread 2");

        // so they will yield right value for `count` variable in MyRunnable
        t1.start();
        t2.start();

        try { 
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName());
    }
}
