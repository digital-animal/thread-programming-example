package com.zahid.itc.producerconsumer1;

public class Producer extends Thread {
	public SharedData data;

	public Producer(SharedData data) {
		this.data = data;
	}

	@Override
	public void run() {
		int i = 1;
		
		while(true) {
			data.setValue(i);
			System.out.println("# Prouced: " + i);
			i++;
			try { Thread.sleep(200);} 
			catch (InterruptedException e) {}
		}
	}
}
