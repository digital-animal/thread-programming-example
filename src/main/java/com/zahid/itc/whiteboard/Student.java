package com.zahid.itc.whiteboard;

public class Student extends Thread {
	public int id;
	public String name;
	public WhiteBoard wb;
	public static int count = 0;
	
	public Student(String name, WhiteBoard wb) {
		this.name = name;
		this.wb = wb;
		id = ++count;
		wb.giveAttendance(); // alike atm.register()
	}

	@Override
	public void run() {
		String text;
		while(true) {
			
			text = wb.copyTextFromWhiteBoard();
			System.out.printf("> `%d.%s` copied `%s` from WhiteBoard\n", id, name, text);
			System.out.flush();
			if(text.equals("end")) break;

			try { Thread.sleep(200); // doesn't work properly without sleep. check later
			} catch (InterruptedException e) {}
		}
	}
	
}
