package com.zahid.itc.bank;

// import java.util.concurrent.TimeUnit;

public class Transaction {
    public static void main(String[] args) {
        Account account = new Account(500);
        System.out.println("[ INITIAL BALANCE ] : $" + account.getBalance());

        Thread depositThread = new Thread(() -> {
            for(int i=0; i<100; i++) {
                account.deposit(100.0);
                // sleep();
            }
        });
        
        Thread withdrawThread = new Thread(() -> {
            for(int i=0; i<100; i++) {
                account.withdraw(100.0);
                // sleep();
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
        
        System.out.println("[ FINAL BALANCE ] : $" + account.getBalance());
    }

    public static void sleep() {
        // try { Thread.sleep(TimeUnit.SECONDS.toMillis(1));}
        // try { Thread.sleep(100);}
        try { Thread.sleep(50);}
        catch (Exception e) {}
    }
}
