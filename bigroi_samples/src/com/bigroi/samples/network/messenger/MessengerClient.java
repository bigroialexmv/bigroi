/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Alexander Medvedev
 *
 */
public class MessengerClient {
	
	private Socket socket;
	
	private String name;
	
	private MessageSender messageSender;
	
	MessageReceiver reciever;
	
	public MessengerClient(Socket socket, MessageListener listener) throws IOException {
		this.socket = socket;
		this.messageSender = new MessageSender(socket);
		this.reciever = new MessageReceiver(socket, listener, this);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public MessageSender getMessageSender() {
		return messageSender;
	}

	public MessageReceiver getReciever() {
		return reciever;
	}
	
	public String getInetAddress() {
		return socket.getInetAddress().toString();
	}

	/**
	 * 
	 */
	public void start() {
		reciever.start();		
	}
	
}
