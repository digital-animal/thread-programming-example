package com.zahid.deadlock.diningphilosopher2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherTest {
    public static void main(String[] args) {
        Lock[] forkList = new Lock[5];
        Philosopher[] philosopherList = new Philosopher[5];

        for(int i=0; i<forkList.length; i++) {
            forkList[i] = new ReentrantLock();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0; i<philosopherList.length; i++) {
            Lock leftFork = forkList[i];
            Lock rightFork = forkList[(i + 1) % forkList.length];

            philosopherList[i] = new Philosopher("Philosopher" + (i+1), leftFork, rightFork);
            executorService.execute(philosopherList[i]);
        }

        executorService.shutdown();
    }
}
