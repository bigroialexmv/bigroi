/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alexander Medvedev
 *
 */
public class MessengerServer implements MessageListener {
	
	private int port;
	
	private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	private List<MessengerClient> clients = Collections.synchronizedList(new ArrayList<MessengerClient>());
	
	public MessengerServer(int port) {
		this.port = port;
	}
	
	
	public void onMessage(Message message, Object source) {
		
		String formatedDate = DATE_FORMAT.format(new Date()); 
		
		MessengerClient client = (MessengerClient) source; 	// client - клиент, от которого получено сообщение
		String name = message.get("name");
		if (name != null) {
			client.setName(name);
			System.out.printf("+ %s connected from %s\n", name, client.getInetAddress());
		}
		
		String cmd = message.get("command");
		if ( "disconnect".equals(cmd) ) {
			System.out.printf("- %s disconnected\n", client.getName());
			clients.remove(client);
			client.getReciever().close();
			return;
		}
		
		String text = message.get("text");
		if ( text != null ) {
			System.out.printf("Message received from client %s: %s\n", client.getName(), text);
			for(MessengerClient c : clients) {
				if (c.equals(client)) continue;
				try {
					Message msg = new Message();
					msg.put("text", text);
					msg.put("from", client.getName());
					msg.put("when", formatedDate);
					c.getMessageSender().sendMessage(msg);
				} catch(Exception e) {
					System.out.println("Failed to send message to client " + client.getName());
				}
			}
		}
		
	}

	public void start() {
		System.out.println("Server started");
		try (
			ServerSocket serverSocket = new ServerSocket(port); // создаем серверный сокет																
			Scanner consoleInput = new Scanner(System.in);		// создаем объект consoleInput, который будет читать сообщения из консоли сервера			
		) {			
			while (true) {				
				Socket socket = serverSocket.accept(); 			// ждем первого / нового клиента и получаем сокет клиента - socket				
				MessengerClient client = new MessengerClient(socket, this); 	// как только новый клент подключился к serverSocket создаем для клиентского сокета объект client				
				clients.add(client); 							// и добавляем его в список подключенных клиентов				
				client.start();									// запускаем поток для получения сообщений от подключенного клиента
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server stopped");
	}

}
