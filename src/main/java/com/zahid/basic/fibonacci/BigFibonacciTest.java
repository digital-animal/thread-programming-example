package com.zahid.basic.fibonacci;

public class BigFibonacciTest {
    public static void main(String[] args) {
        BigFibonacci t1 = new BigFibonacci(45, "1");
        BigFibonacci t2 = new BigFibonacci(45, "2");
        BigFibonacci t3 = new BigFibonacci(45, "3");
        BigFibonacci t4 = new BigFibonacci(45, "4");
        BigFibonacci t5 = new BigFibonacci(45, "5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
