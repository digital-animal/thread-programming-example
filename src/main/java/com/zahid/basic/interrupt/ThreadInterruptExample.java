package com.zahid.basic.interrupt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ThreadInterruptExample {
    // private static boolean running = true; // flag to exit thread
    private static volatile boolean running = true; // flag to exit thread, L1, L2, L3
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    clearConsole();
                    printCurrentTime();
                    sleepOneSecond();

                    if(Thread.interrupted()) {
                        System.out.println("Thread Interrupted");
                        return;
                    }

                }
            }
        });
        t1.start();

        try { Thread.sleep(TimeUnit.SECONDS.toMillis(10));} 
        catch (InterruptedException e) {}

        // t1.stop(); // never recommended
        // t1.interrupt(); // works only when clearConsole()  & sleepOneSecond() commented
        shutdown();
    }

    // printCurrentTime
    public static void printCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String formattedCurrentTime = LocalDateTime.now().format(dtf);
        System.out.println(formattedCurrentTime);
    }

    // sleepOneSecond
    public static void sleepOneSecond() {
        // try { Thread.sleep(1000);} 
        // try { Thread.sleep(TimeUnit.SECONDS.toMillis(1));} 
        try { TimeUnit.SECONDS.sleep(1);}  // TimeUnit enum
        catch (InterruptedException e) {}
    }

    // clearConsole short, concise
    public static void clearConsole() {

        try {
            if(System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // safe thread interrupt i.e. shutdown
    public static void shutdown() {
        running = false;
    }
}
