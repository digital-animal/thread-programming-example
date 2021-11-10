/**
 * This program is a demonstration of producer consumer problem using multi threading
 */

package com.zahid.itc.producerconsumer1;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		// SharedData sharedData = new SharedData();
		SharedData sharedData = SharedData.getInstance();
		
		Producer producerThread = new Producer(sharedData);
		Consumer consumerThread = new Consumer(sharedData);
		
		producerThread.start();
		consumerThread.start();

	}

}
