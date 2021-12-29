package com.zahid.itc.producerconsumer2;

public class ProducerConsumerTest {
    public static void main(String[] args) {

        // IntrinsicLockingBuffer buffer = new IntrinsicLockingBuffer();
        ExplicitLockingBuffer buffer = new ExplicitLockingBuffer();

        Thread producerThread = new Thread(() -> {
            int i = 1;
            while (true) {
                System.out.println("# Produced: " + i);
                buffer.addItem(i++);
                sleep(200);
            }
        }, "Producer");
        
        Thread consumerThread = new Thread(() -> {
            int value;
            while(true) {
                value = buffer.getItem();
                System.out.println("$ Consumed: " + value);
            }
        }, "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
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
