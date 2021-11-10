package com.zahid.deadlock.diningphilosopher2;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread {
    private String name;
    private final Lock leftFork;
    private final Lock rightFork;

    public Philosopher(String name, Lock leftFork, Lock rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() {
        System.out.printf("[%s] %s thinking..\n", Thread.currentThread().getName(), name);
        sleep(getRandomTime());
    }
    public void eat() {
        System.out.printf("[%s] %s eating..\n", Thread.currentThread().getName(), name);
        sleep(getRandomTime());
    }

    @Override
    public void run() {
        while(true) {
            think();
            // `tryLock` type locking & unlocking must be inside try{lock}..finally{unlock} block
            if(leftFork.tryLock()) { // acquiring left fork
                try {
                    System.out.printf("[%s] %s acquired left fork\n", Thread.currentThread().getName(), name);
                    if(rightFork.tryLock()) { // acquiring right fork
                        try {
                            System.out.printf("[%s] %s acquired right fork\n", Thread.currentThread().getName(), name);
                            eat();
                        } finally {
                            rightFork.unlock(); // releasing right fork
                            System.out.printf("[%s] %s releasing right fork\n", Thread.currentThread().getName(), name);
                        }
                    }
                } finally {
                    leftFork.unlock(); // releasing left fork
                    System.out.printf("[%s] %s releasing left fork\n", Thread.currentThread().getName(), name);
                    System.out.println();
                }
            }
        }
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

    public static int getRandomTime() {
        return new Random().nextInt(1000);
    }

}
