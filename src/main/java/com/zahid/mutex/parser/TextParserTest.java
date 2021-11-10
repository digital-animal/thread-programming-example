package com.zahid.mutex.parser;

public class TextParserTest {

	public static void main(String[] args) {
		TextParser textParser = new TextParser(); // shared object for both thread
		
		String line1 = "Once upon a time in the wild west, there were three bounty hunters named Alex, Lee, Cooper";
		String line2 = "Welcome to Java Programming. Thread is an excellent tool for concurrent program execution.";
		
		MyThread1 t1 = new MyThread1(textParser, line1);
		// MyThread1 t2 = new MyThread1(textParser, line2); // convenient, DRY followed
		MyThread2 t2 = new MyThread2(textParser, line2); // not convenitent, why make two thread class with exactly smae signature?

		t1.start();
		t2.start();
	}
}
