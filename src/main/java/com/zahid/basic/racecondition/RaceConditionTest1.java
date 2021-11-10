package com.zahid.basic.racecondition;

public class RaceConditionTest1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable(); // single runnable object shared runnable object

        // both the thread share same runnable object
        Thread t1 = new Thread(myRunnable, "Thread 1");
        Thread t2 = new Thread(myRunnable, "Thread 2");

        // so they will yield wrong value for `count` variable in MyRunnable
        t1.start();
        t2.start();
    }
}
