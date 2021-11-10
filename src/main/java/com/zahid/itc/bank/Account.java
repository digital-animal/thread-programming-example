package com.zahid.itc.bank;

public class Account {
    private double balance;
    // private volatile double balance; // not needed if `synchronized` keyword is used
    private boolean deposited = false;

    public Account(double initialAmount) {
        this.balance = initialAmount;
    }

    public synchronized void withdraw(double amount) { // critial section 1
        while (deposited == false) { // not yet deposited.. how can you withdraw? so wait..wait..
            try { wait();} 
            catch (InterruptedException e) {}
        }
        System.out.println("(-) Withdrawing $" + amount);
        double netBalance = balance - amount; // consumed
        System.out.println("# Net Balance: $" + netBalance);
        balance = netBalance;
        deposited = false;
        notify();
    }
    
    public synchronized void deposit(double amount) { // critical section 2
        while (deposited == true) { // deposited once, why again? so wait..wait for consuming(withdrawing)
            try { wait();} 
            catch (InterruptedException e) {}
        }
        System.out.println("(+) Depositing $" + amount);
        double netBalance = balance + amount;
        System.out.println("# Net Balance: $" + netBalance);
        balance = netBalance;
        deposited = true;
        notify();
    }

    public double getBalance() {
        return balance;
    }
}
