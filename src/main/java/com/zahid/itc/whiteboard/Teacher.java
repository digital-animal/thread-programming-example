package com.zahid.itc.whiteboard;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Thread {

	// message list for writing on whiteboard
	List<String> messagList = new ArrayList<>(List.of(
		"Java is an OOP Language", 
		"Java Supports Multi Threading",
		"Design Pattern is essential in Software Engineering",
		"Mutex, Semaphore, Monitor & IPC",
		"CountDownLatch, Cyclic Barrier, Phaser",
		"end" 
	));
	WhiteBoard wb;
	
	public Teacher(WhiteBoard wb) {
		this.wb = wb;
	}

	@Override
	public void run() {
		
		String message;
		for(int i=0; i<messagList.size(); i++) {
			message = messagList.get(i);
			wb.writeTextOnWhiteBoard(message);
			System.out.printf("\n# TEACHER has written `%s`\n", message);

			try { Thread.sleep(1000);  // doesn't work properly without sleep. check later
			} catch (InterruptedException e) {}
		}
	}
}
