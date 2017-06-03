package com.bigroi.homework.lesson08.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// начинаем с MeessengerServerApp.main

class ServerClient implements Runnable {
	
	private Socket socket;
	
	private String name;
	
	private DataOutputStream dos;
	
	private MessageListener messageListener;
	
	public ServerClient(Socket socket, MessageListener messageListener) {
		this.socket = socket;
		this.messageListener = messageListener;
	}
	
	public String getName() {
		return name;
	}
	
	public DataOutputStream getOutputStream() throws IOException {
		if (dos == null) {
			dos = new DataOutputStream( socket.getOutputStream() );
		}
		return new DataOutputStream( socket.getOutputStream() );
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();		
			DataInputStream dis = new DataInputStream(is);
			name = dis.readUTF();							// клиент после подключения посылает свое имя - читаем его из inputStream сокета 
			System.out.println(name + " connected");
			while (true) {
				String message = dis.readUTF();				// читаем сообщение от клиента
				System.out.printf("Message recieved from %s: %s\n", name, message);
				messageListener.onMessage(this, message);	// вызываем метод onMessage() у объекта server
				if ("quit".equals(message)) {				// если клиент отправил сообщение quit выходим из цикла
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface MessageListener {
	
	void onMessage(ServerClient from, String message);
	
}

class Server implements MessageListener {
	
	private List<ServerClient> clients =				// хранит всех подключенных к серверу клиентов
			Collections.synchronizedList( new ArrayList<ServerClient>() );
	
	public void onMessage(ServerClient from, String message) {
		if ("quit".equals(message)) {	// если клиент отправил сообщение quit 
			from.close();				// закрываем сокет клиента
			clients.remove(from);		// удаляем клиента и списка клиентов (чтобы больше не отпралять ему сообщений)
			return;						// выходим из метода
		}
		for(ServerClient client : clients) {			// для всех подключенных клиентов
			if ( client.equals(from) ) continue;		// за исключением клиента, от которого получено сообщение message,										
			try {										// отпраляем message
				System.out.println("Sending message to " + client.getName());
				DataOutputStream dos = client.getOutputStream();
				String msg = String.format("%s: %s", from.getName(), message);
				dos.writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {		
		
		System.out.println("Server started");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9988);			// создаем серверный сокет с портом 9988
															// если дргое приложение уже использует порт 9988, произойдет ошибка
			while(true) {
				Socket socket = serverSocket.accept();		// ждем подключения клиента (выполнение остановится, если к serverSocket-у еще никто не подключился);
															// как только к сервеному сокету подключается клиентский сокет,
															// 		метод accept() возвращает объект socket - представителя сокета клиента
				System.out.println( "Client connected: " + socket.getInetAddress() ); // выводим в консоль адрес клиента
			
				ServerClient client = new ServerClient(socket, this); 	// для каждого подключенного клиента создаем объект типа ServerClient
																		// (передаем ему socket и сам объект server в качестве слушателя сообщений - см. onMessage()
				clients.add(client);									// добавляем его в список клиентов
				
				Thread thread = new Thread(client);			// ServerClient реализует интерфейс Runnable
				thread.start();								// запускаем метод ServerClient.run() в отдельном потоке
			}		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();					// закрываем сокет
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Server stopped");
	}
}

public class MessengerServerApp {	
	
	public static void main(String[] args) {		
		Server server = new Server();	// создаем объект сервер
		server.start();					// и запускаем его
	}

}
