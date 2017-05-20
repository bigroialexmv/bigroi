/**
 * 
 */
package com.bigroi.samples.network.messenger;

/**
 * @author Alexander Medvedev
 *
 */
public class MessengerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Messenger client = new Messenger("localhost", 9988);
		client.start();
	}

}
