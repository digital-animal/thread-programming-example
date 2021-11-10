package com.zahid.basic.method;

public class MyThread extends Thread {

	public MyThread() {
		super();
		// setPriority(Thread.MIN_PRIORITY);
		setPriority(Thread.MIN_PRIORITY + 2);
		
	}

	public MyThread(String name) {
		super(name);
		setPriority(Thread.MAX_PRIORITY);
	}

	@Override
	public void run() {
		int count = 1;
		while(true) {
			try {
				// Thread.sleep(1000);
				Thread.sleep(100);
				// Thread.sleep(10);
				// Thread.sleep(0);
				
			} catch (InterruptedException e) {
				System.out.print(e);
				// System.out.print(e.getMessage());
			}
			System.out.println(count++ +": "+ this.getClass().getSimpleName());
			// if(count > 50) break;
			if(count > 10) break;
		}
	}
}
