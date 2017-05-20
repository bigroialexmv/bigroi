/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Alexander Medvedev
 *
 */
public class Messenger implements MessageListener {
	
	private String host;
	
	private int port;
	
	public Messenger(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void onMessage(Message message, Object source) {
		String when = message.get("when");
		String from = message.get("from");
		String text = message.get("text");
		System.out.printf( "[%s] %s: %s\n", when, from, text); // (1)				
	}
	
	public void start() {		
		try (
			Scanner consoleInput = new Scanner(System.in); 		// создаем объект consoleInput, который будет читать сообщения из консоли клиента				
			Socket socket = new Socket(host, port); 			// подключаемся к серверу				
			MessageSender sender = new MessageSender(socket); 	// создаем объект sender, который будет посылать сообщения на сервер			
			MessageReceiver reciever = new MessageReceiver(socket, this); // создаем объект reciever, 
																// который будет принимать сообщения от сервера в отдельном потоке
																// по получению сообщения от сервера будет вызываться метод onMessage
		) {			
			System.out.print("Your name: "); 
			String clientName = consoleInput.nextLine(); 		// запрашиваем имя клиента из консоли
			
			Message message = new Message();
			message.put("name", clientName);
			sender.sendMessage(message); 						// отправляем имя клиента на сервер
			
			reciever.start(); 									// запускаем поток для получения сообщений от сервера
			
			while(true) { 										// читаем сообщения из консоли и посылаем их на сервер
				String input = consoleInput.nextLine();
				if ( "quit".equals(input) ) { 					// если пользовтель ввел quit - завершаем работу: посылаем на сервер комманду disconnect
					Message msg = new Message();
					msg.put("command", "disconnect");
					sender.sendMessage(msg); 					// отправляем комманду disconnect на сервер
					break;
				} else {
					Message msg = new Message();
					msg.put("text", input);
					sender.sendMessage(msg);					// посылаем сообщение пользователя на сервер
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Bye!");
	}

}
