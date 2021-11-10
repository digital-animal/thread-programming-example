package com.zahid.latch;

public class Utility {
    
    public static void sleep() {
        // try { Thread.sleep(TimeUnit.SECONDS.toMillis(1));}
        try { Thread.sleep(100);}
        catch (Exception e) {}
    }

    public static void sleep(int ms) {
        try { Thread.sleep(ms);}
        catch (Exception e) {}
    }
}
