package com.zahid.itc.producerconsumer1;

public class SharedData {
	private static SharedData instance = null;
	public int value = 0;
	public static boolean valueConsumed = false;

	// making singleton class
	private SharedData(){}

	public static SharedData getInstance() {
		if(instance == null) {
			instance = new SharedData();
		}
		return instance;
	}
	
	synchronized void setValue(int v) { // producer
		while(valueConsumed == false) // until not consumed by consumer, producer waits
		{
			try { wait();} 
			catch (InterruptedException e) {}			
		}
		value = v; // new value produced by producer for consuming by consumer
		valueConsumed = false; // again set valueConsumed to false
		notify();
	}
	
	synchronized int getValue() { // consumer
		int x = 0;
		while(valueConsumed == true) { // until producer finished producing new value, cosumer waits
			try { wait();} 
			catch (InterruptedException e) {}	
		}
		x = value; // cosuming value
		valueConsumed = true;
		notify();
		
		return x;
	}
}
