package com.zahid.deadlock.runandwalk;

public class Deadlock {
    public final Object lock1 = new Object(); // object lock, explicit lock
    public final Object lock2 = new Object(); // object lock, explicit lock

    public void running() {
        synchronized(lock1) {
            System.out.printf("[%s] Acquired lock 1\n", Thread.currentThread().getName()); 
            synchronized(lock2) {
                System.out.printf("\t[%s] Acquired lock 2\n", Thread.currentThread().getName()); 
            }
            System.out.printf("\t[%s] Releasing lock 2\n", Thread.currentThread().getName()); 
        }
        System.out.printf("[%s] Releasing lock 1\n", Thread.currentThread().getName()); 
        System.out.println();
    }

    public void walking() {
        synchronized(lock2) {
            System.out.printf("[%s] Acquired lock 2\n", Thread.currentThread().getName()); 
            synchronized(lock1) {
                System.out.printf("\t[%s] Acquired lock 1\n", Thread.currentThread().getName()); 
            }
            System.out.printf("\t[%s] Releasing lock 1\n", Thread.currentThread().getName()); 
        }
        System.out.printf("[%s] Releasing lock 2\n", Thread.currentThread().getName()); 
        System.out.println();
    }
}
