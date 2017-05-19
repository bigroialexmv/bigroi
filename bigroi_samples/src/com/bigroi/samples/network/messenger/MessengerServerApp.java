/**
 * 
 */
package com.bigroi.samples.network.messenger;

/**
 * @author Alexander Medvedev
 *
 */

public class MessengerServerApp {
	
	public static void main(String[] args) {
		MessengerServer server = new MessengerServer(9988);
		server.start();
	}

}
