package org.VovaYa.lesson08.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MessengerServerApp {
	
	public static void main(String[] args) {
		System.out.println("Server started");
		ServerSocket serverSocket = null;
		try {
			
			while (true){
				serverSocket = new ServerSocket(9988);
				Socket socket = serverSocket.accept();
			
				ServerClient client = new ServerClient(socket);
				Thread thread = new Thread(client);
				thread.start();
			}
			
			System.out.println("Client connected" + socket.getInputStream());
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			while (true) {			
			String message = dis.readUTF();
			System.out.println("Recieves:" + message);
			if ("quit".equals(message)){
				break;
			}
			}
			
		System.out.println("Client connected:" + socket.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null ){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Server closed");
	}
	

}
