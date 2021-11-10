package com.zahid.latch;

import java.util.concurrent.CountDownLatch;
import static com.zahid.latch.Utility.sleep;

public class Developer implements Runnable {
    private CountDownLatch latch;
    private String name;

    public Developer(String name, CountDownLatch latch) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("# Task assigned to developer: %s\n", name);
        sleep(2000);
        System.out.printf("# Task finished by developer: %s\n", name);
        
        this.latch.countDown(); // `counter` value decreases in every thread call/start and finally becomes 0
    }
    
}
