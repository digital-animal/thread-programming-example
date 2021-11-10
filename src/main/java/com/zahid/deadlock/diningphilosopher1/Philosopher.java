package com.zahid.deadlock.diningphilosopher1;

import java.util.Random;

public class Philosopher extends Thread {
    private String name;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() {
        System.out.printf("[%s] %s thinking..\n", Thread.currentThread().getName(), name);
    }
    public void eat() {
        System.out.printf("[%s] %s eating..\n", Thread.currentThread().getName(), name);
        sleep(getRandomEatingTime());
    }

    @Override
    public void run() {
        while(true) {
            think();
            synchronized(leftFork) { // acquiring left fork
                System.out.printf("[%s] %s acquired left fork\n", Thread.currentThread().getName(), name);
                synchronized(rightFork) { // acquiring right fork
                    System.out.printf("[%s] %s acquired right fork\n", Thread.currentThread().getName(), name);
                    eat();
                    System.out.printf("[%s] %s releasing right fork\n", Thread.currentThread().getName(), name);
                }
                System.out.printf("[%s] %s releasing left fork\n", Thread.currentThread().getName(), name);
                System.out.println();
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

    public static int getRandomEatingTime() {
        return new Random().nextInt(1000);
    }

}
