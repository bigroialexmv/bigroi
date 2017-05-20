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
				String message = dis.readUTF();
				System.out.println(message);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}	
	
}


public class MeessengerClientApp {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Your name: ");
		String name = scanner.nextLine();

		try {
			socket = new Socket("192.168.0.100", 9988);
			
			ClientServer server = new ClientServer(socket);
			
			Thread thread = new Thread(server);
			thread.start();
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(name);
			
			while(true) {
				String message = scanner.nextLine();				
				dos.writeUTF(message);
				if ("quit".equals(message)) {
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
