package com.zahid.mutex.parser;

public class TextParser {
	
	// no synchronization
	/* void display(String str) {
		for(int i=0; i<str.length(); i++) {
			System.out.print(str.charAt(i));

			try {
				Thread.sleep(20);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	} */
	
	// block level synchronization
	/* void display(String str) {

		synchronized(this) {

			for(int i=0; i<str.length(); i++) {
				System.out.print(str.charAt(i));

				try {
					Thread.sleep(20);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			System.out.println();
		}
	} */
	
	// method level synchronization
	synchronized void display(String str) {

		for(int i=0; i<str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				// Thread.sleep(100);
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}
 
}
