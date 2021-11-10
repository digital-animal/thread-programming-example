package com.zahid.itc.printer;

public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // anonymous class instantiation
        new Person("Alex", 10, printer);
        new Person("Lee", 5, printer);
        new Person("Cooper", 8, printer);
        new Person("John", 2, printer);
        new Person("Hannah", 6, printer);
    }
}
