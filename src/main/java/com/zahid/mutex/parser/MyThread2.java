package com.zahid.mutex.parser;

public class MyThread2 extends Thread {
	TextParser textParser;
	String text;

	public MyThread2(TextParser textParser, String text) {
		this.textParser = textParser;
		this.text = text;
	}

	@Override
	public void run() {
		textParser.display(text);
	}

}
