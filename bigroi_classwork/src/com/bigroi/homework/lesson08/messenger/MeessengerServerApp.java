package com.bigroi.homework.lesson08.messenger;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ServerClient implements Runnable {
	
	private Socket socket;
	
	public ServerClient(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();		
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				String message = dis.readUTF();				// читаем сообщение от клиента
				System.out.println("Recieved: " + message);
				if ("quit".equals(message)) {				// если клиент отправил quit выходим из цикла
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class MeessengerServerApp {

	public static void main(String[] args) {
		System.out.println("Server started");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9988);			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println( "Client connected: " + socket.getInetAddress() );
			
				ServerClient client = new ServerClient(socket);
				Thread thread = new Thread(client);
				thread.start();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Server stopped");
	}

}
