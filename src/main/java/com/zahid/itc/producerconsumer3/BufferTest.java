package com.zahid.itc.producerconsumer3;

import java.util.Random;

public class BufferTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        
        Thread producer = new Thread(() -> {
            while (true) {
                int num = new Random().nextInt(1000);
                buffer.addItem(num);
                System.out.println("# Produced: " + num);
                // int t = 200;
                int t = new Random().nextInt(1000);
                sleep(t);
            }
        });
        
        Thread consumer = new Thread(() -> {
            while (true) {
                Integer item = buffer.getItem();
                System.out.println("$ Consumed: " + item);
                // int t = 200;
                int t = new Random().nextInt(200);
                // int t = new Random().nextInt(1);
                sleep(t);
            }
        });

        producer.start();
        consumer.start();
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
