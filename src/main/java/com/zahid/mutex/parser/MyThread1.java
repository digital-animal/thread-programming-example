package com.zahid.mutex.parser;

public class MyThread1 extends Thread {
	TextParser textParser;
	String text;

	public MyThread1(TextParser textParser, String text) {
		this.textParser = textParser;
		this.text = text;
	}

	@Override
	public void run() {
		textParser.display(text);
	}

}
