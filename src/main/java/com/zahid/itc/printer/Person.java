package com.zahid.itc.printer;

import lombok.Data;

@Data
public class Person implements Runnable{
    private String name;
    private int totalPages;
    private Printer printer;

    public Person(String name, int totalPages, Printer printer) {
        this.name = name;
        this.totalPages = totalPages;
        this.printer = printer;
        new Thread(this).start(); // anonymous thread instantiation and start
    }

    @Override
    public void run() {
        printer.printPages(this); // passing this object to printer
    }
}
