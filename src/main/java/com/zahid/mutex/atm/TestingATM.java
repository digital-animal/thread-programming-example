package com.zahid.mutex.atm;

public class TestingATM {

	public static void main(String[] args) {
		ATM atm = ATM.getInstance(); // singleton
		
		Customer c1 = new Customer("Alex", 2000, atm);
		Customer c2 = new Customer("Lee", 1500, atm);
		Customer c3 = new Customer("Cooper", 1200, atm);
		Customer c4 = new Customer("David", 1000, atm);
		Customer c5 = new Customer("John", 2500, atm);
		
		System.out.println("# INITIAL BALANCE: $" + atm.getTotalBalance());
		System.out.println();

		/* c1.useATM();
		c2.useATM();
		c3.useATM();
		c4.useATM();
		c5.useATM(); */

		c1.start();
		c2.start();
		c3.start();
		c4.start(); 
		c5.start();

		// joining with main thread
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
			c5.join();
		} catch (InterruptedException e) {}

		System.out.println();
		System.out.println("# FINAL BALANCE: $" + atm.getTotalBalance());
	}

}
