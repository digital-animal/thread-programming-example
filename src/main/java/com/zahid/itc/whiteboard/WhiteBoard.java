package com.zahid.itc.whiteboard;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WhiteBoard {
	// public int turn = 0; // O for teacher, non-zero for others
	public int studentCount = 0;
	public volatile static int count = 5;

	BlockingQueue<String> messageQueue = new LinkedBlockingDeque<>(10);

	public WhiteBoard() {
		// pass
	}

	public synchronized void writeTextOnWhiteBoard(String message) { // teacher writes to

		try { messageQueue.put(message);
		} catch (InterruptedException e) {}
		notifyAll();
	}
	
	public synchronized String copyTextFromWhiteBoard() { // student reads from
		String text = "";

		while(messageQueue.isEmpty()) {
			try { wait();} 
			catch (InterruptedException e) {}
		}

		try {
			text = messageQueue.peek();
			count--;
			if(count == 0) {
				messageQueue.take();
				count = studentCount;
			}
		} catch (Exception e) {}

		notifyAll();
		return text;
	}

	public synchronized void giveAttendance() {
		studentCount++;
	}
	
}
