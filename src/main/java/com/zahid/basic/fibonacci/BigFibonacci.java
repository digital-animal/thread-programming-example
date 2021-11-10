package com.zahid.basic.fibonacci;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BigFibonacci extends Thread {
    private long n;
    private String id;
    public BigFibonacci(long n, String id) {
        this.n = n;
        this.id = id;
    }

    synchronized public BigDecimal fibo(long n) {
        if(n == 0) return BigDecimal.ZERO;
        else if(n == 1) return BigDecimal.ONE;
        else return fibo(n - 1).add(fibo(n - 2));
    }

    @Override
    public void run() {
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.printf("# Starting task %s at %s\n", id, isoFormatter.format(LocalDateTime.now()));
        fibo(n); // just calculating fibonacci two elapse time
        System.out.printf("# Ending task %s at %s\n", id, isoFormatter.format(LocalDateTime.now()));
        
    }
}
