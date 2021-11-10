package com.zahid.basic.unsafe;

public class ThreadUnsafeExample {

    // public static boolean s = false; // thread unsafe
    public volatile static boolean s = false; // now thread safe
    public static void main(String[] args) {
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!s) {
                    // pass
                }
                System.out.println("Hello World!");       
            }
        });

        t1.start();
        
        Thread t2 = new Thread(() -> {
            s = true;
            System.out.println("Welcome to Java Programming");
            System.out.println("Goodbye");
        });

        // t1.start();
        t2.start();
    } 
}
