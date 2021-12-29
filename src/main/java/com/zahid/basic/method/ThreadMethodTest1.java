package com.zahid.basic.method;

public class ThreadMethodTest1 {

	public static void main(String[] args) {
		// # Thread 1
		// Thread t1 = new Thread();
		// Thread t1 = new Thread("My Thread");
		// Thread t1 = new Thread(new MyRunnable(), "My Runnable");
		// MyThread t1 = new MyThread();
		MyThread t1 = new MyThread("My Thread 1");
		
		System.out.println("ID = " + t1.getId());
		System.out.println("Name = " + t1.getName());
		System.out.println("Priority = " + t1.getPriority());
		System.out.println("State = " + t1.getState());
		System.out.println("Is Alive = " + t1.isAlive());
		System.out.println();
		
		// t1.start();
	
		// # Thread 2
		MyThread t2 = new MyThread();
		System.out.println("ID = " + t2.getId());
		System.out.println("Name = " + t2.getName());
		System.out.println("Priority = " + t2.getPriority());
		System.out.println("State = " + t2.getState());
		System.out.println("Is Alive = " + t2.isAlive());
		System.out.println();
		
	}

}
