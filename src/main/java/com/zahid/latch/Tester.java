package com.zahid.latch;

import java.util.concurrent.CountDownLatch;

public class Tester implements Runnable {
    private CountDownLatch latch;
    private String name;

    public Tester(String name, CountDownLatch latch) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.printf("$ Tester %s waiting for developers to finish their work\n", name);
            latch.await(); // waits until `counter` becomes 0 & finally proceedes to next block
        } catch (InterruptedException e) {}

        System.out.printf("$ Testing done by tester %s\n", name);
        
    }
    
}
