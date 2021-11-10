package com.zahid.basic.racecondition;

public class MyRunnable implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for(int i=0; i<1_000_000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.count);
    }
    
}