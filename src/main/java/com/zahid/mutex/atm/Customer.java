package com.zahid.mutex.atm;

public class Customer extends Thread {
	public ATM atm;
	String customerID;
	String name;
	double amount;

	public static int count = 0;
	
	public Customer(String name, double amount, ATM atm) {
		this.atm = atm; 
		this.name = name;
		this.amount = amount;
		this.customerID = String.format("%03d", ++count);
		atm.registerCustomer(this);
	}

	public void useATM() {
		atm.checkBalance(this.customerID);
		atm.withdrawBalance(this.customerID, 500.0);
		// atm.unregisterCustomer(this.customerID);
	}

	@Override
	public void run() {
		useATM();
	}

	
	public String getCustomerName() {
		return name;
	}

	public String getCustomerID() {
		return customerID;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "\tCustomerId: " + customerID + "\n" +
				"\tName: " + name + "\n" +
				"\tBalance: $" + amount;
	}
}
