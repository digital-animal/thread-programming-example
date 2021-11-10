package com.zahid.basic.intro;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread(); // MyThread extends Thread
        Thread t2 = new Thread(new MyRunnable()); // MyRunnable implements Runnable
        Thread t3 = new Thread(new Runnable() { // Thread using anonymous inner class
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println("Anonymous: " + i);
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for(int i=0; i<100; i++) {
                System.out.println("Lambda:  " + i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        for(int i=0; i<100; i++) { // loop inside main thread
            System.out.println("Main: " + i);
        }
    }
}
