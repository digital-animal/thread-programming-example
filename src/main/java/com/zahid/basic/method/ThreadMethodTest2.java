package com.zahid.basic.method;

public class ThreadMethodTest2 {

	public static void main(String[] args) {
		// # Thread 3, interrupt
		MyThread t3 = new MyThread("My Thread 3");
		t3.start();
		t3.interrupt();
		System.out.println(t3);
		System.out.println();
		
		// # Thread 4, Daemon thread, setDaemon
		MyThread t4 = new MyThread("My Thread 4");
		t4.setDaemon(true); // so, it terminates when main thread terminates
		t4.start();
		System.out.println(t4);
		System.out.println();
		
		// sleeping main thread
		// try {
		// 	Thread.sleep(100);
		// } catch(Exception e) {
		// 	System.out.println(e);
		// }
		
		// # Main Thread, join
		Thread mainThread = Thread.currentThread();
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// # Main Thread, yield
		int count = 1;
		while(true) {
			System.out.println(count++ + " Main Thread");
			Thread.yield(); // passing control to other thread in case of starvation
			if(count > 10) break;
		}
		System.out.println();
		
		// # Thread 5
		MyThread t5 = new MyThread();
		t5.start();
	}

}
