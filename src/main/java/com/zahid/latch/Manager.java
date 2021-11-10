package com.zahid.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(2); // 2 - decrements in every developer thread start..then it triggers tester thread if it is 0

        Developer developer1 = new Developer("Alex", latch);
        Developer developer2 = new Developer("Hannah", latch);
        Tester tester = new Tester("Cooper", latch);

        executorService.execute(developer1);
        executorService.execute(developer2);
        executorService.execute(tester);

        executorService.shutdown();
    }
}
