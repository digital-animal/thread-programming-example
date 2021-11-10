package com.zahid.mutex.atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {
	private static ATM instance = null;
	protected double totalBalance = 0;
	private static Map<String, Customer> customerMap = new HashMap<>();
	
	private ATM() {
		// pass
	}	

	// generating singleton instance
	public static ATM getInstance() {
		if(instance == null) {
			instance = new ATM();
		}
		return instance;
	}
	
	public double getTotalBalance() {
		totalBalance = 0; // weird trick..does work but..
		for(Map.Entry<String, Customer> customer: customerMap.entrySet()) {
			totalBalance += customer.getValue().getAmount();
		}
		return totalBalance;
	}

	// utility method, register customer
	synchronized public void registerCustomer(Customer customer) {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("# REGISTER");
		if(!customerMap.containsKey(customer.getCustomerID())) {

			customerMap.put(customer.getCustomerID(), customer);

			System.out.println("(+) Registeration Successfull. Customer Details:");
			System.out.println(customer);
			System.out.println();
		}
	}
	
	// utility method, unregister customer
	synchronized public void unregisterCustomer(String customerID) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("# UNREGISTER");
		if(customerMap.containsKey(customerID)) {
			customerMap.remove(customerID, customerMap.get(customerID));
			System.out.printf("(-) CustomeID: %s unregistered Successfully. Thank You.\n", customerID);
			System.out.println();
		}
	}

	// # check balance, without synchronization
	synchronized public void checkBalance(String customerID) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println("# CHECK BALANCE ");
		if(customerMap.containsKey(customerID)) {

			System.out.println(customerMap.get(customerID));
			System.out.println();
			
		} else {
			System.out.println("# Sorry, no customer entry found for the customer id: " + customerID);
			System.out.println();
		}
	}
	
	// # withdraw balance, without synchronization
	synchronized public void withdrawBalance(String customerID, double amount) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("# WITHDRAW BALANCE ");
		if(customerMap.containsKey(customerID) && amount < customerMap.get(customerID).getAmount()) {

			customerMap.get(customerID).setAmount(customerMap.get(customerID).getAmount() - amount);

			System.out.println("\t$" + amount + " withdrawn successfully for customerID: " + customerID);
			System.out.println();
		} else {
			System.out.println("# Sorry, unsuccessful transaction. Try again later.");
			System.out.println();
		}
	}
}
