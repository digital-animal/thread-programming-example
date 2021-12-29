package com.zahid.deadlock.runandwalk;

public class DeadlockTest {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        
        Thread runningThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                deadlock.running();
                // sleep();
                sleep(1000);
            }
        }, "Running Thread");
        
        Thread walkingThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                deadlock.walking();
                // sleep();
                sleep(1000);
            }
        }, "Walking Thread");

        runningThread.start();
        walkingThread.start();

        // sleep(5000);
        // Thread.interrupted();

        try {
            runningThread.join();
            walkingThread.join();
        } catch (InterruptedException e) {}
    }

    public static void sleep() {
        // try { Thread.sleep(TimeUnit.SECONDS.toMillis(1));}
        try { Thread.sleep(100);}
        catch (Exception e) {}
    }

    public static void sleep(int ms) {
        try { Thread.sleep(ms);}
        catch (Exception e) {}
    }
}
