package com.bigroi.homework.lesson08.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


class ClientServer implements Runnable {
	
	private Socket socket;
	
	private DataInputStream dis;

	public ClientServer(Socket socket) throws IOException {
		super();
		this.socket = socket;
		this.dis = new DataInputStream( socket.getInputStream() );
	}

	@Override
	public void run() {		
		while(true) {
			try {
				String message = dis.readUTF();		// получаем сообщения от сервера
				System.out.println(message);		// и выводим их в консоль
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}	
	
}


public class MessengerClientApp {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Your name: ");
		String name = scanner.nextLine();

		try {
			socket = new Socket("localhost", 9988);				// подключаемся к серверному сокету
			
			ClientServer server = new ClientServer(socket);		// создаем объект типа ClientServer с метом run(),
																// в котором будем слушать / читать сообщения от сервера
			Thread thread = new Thread(server);
			thread.start();
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(name);									// посылаем серверу введенное в консоли имя
			
			while(true) {
				System.out.println(name + ": ");			
				String message = scanner.nextLine();			// читаем сообщения из консоли	
				dos.writeUTF(message);							// и отправляем их на сервер
				dos.flush();
				if ("quit".equals(message)) {					// выходим из цикла как только получаем команду quit
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
