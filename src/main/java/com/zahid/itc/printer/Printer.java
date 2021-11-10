package com.zahid.itc.printer;

import java.util.concurrent.TimeUnit;

public class Printer {
    synchronized public void printPages(Person person) {
        String personName = person.getName();

        System.out.println("# " + personName + " started printing..");
        for(int i=1; i<=person.getTotalPages(); i++) {
            System.out.println("=> printed page #" + i + " for " + personName);
            // sleep(100);
            sleep(400);
        }
        System.out.println("# " + personName + " finished printing..");
        System.out.println();
    }

    public void sleep(int ms) {
        try { TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
