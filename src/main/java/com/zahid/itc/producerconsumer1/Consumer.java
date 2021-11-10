package com.zahid.itc.producerconsumer1;

public class Consumer extends Thread {
	public SharedData data;

	public Consumer(SharedData data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("> Consumed: " + data.getValue());
			try { Thread.sleep(100);} 
			catch (InterruptedException e) {}
		}
	}
}
