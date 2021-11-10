package com.zahid.mutex.counter;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                counter.incremet();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                counter.decremet();
            }
        });
        long starTime = System.nanoTime();

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {}
        
        long endTime = System.nanoTime();
        System.out.println("# Duration: " + (endTime - starTime));
        // System.out.println("# Duration: " + (endTime - starTime) / Math.pow(10, 9));
    }
}
