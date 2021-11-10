package com.zahid.basic.racecondition;

public class RaceConditionTest2 {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable(); 
        MyRunnable myRunnable2 = new MyRunnable(); 

        // separed runnable object passed to each thread
        Thread t1 = new Thread(myRunnable1, "Thread 1");
        Thread t2 = new Thread(myRunnable2, "Thread 2");

        // so they will yield right value for `count` variable in MyRunnable
        t1.start();
        t2.start();
    }
}
