package org.VovaYa.lesson08.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


class ServerClient implements Runnable{
	
	private Socket socket;
	
	public ServerClient(Socket socket){
		this.socket =  socket;
	}

	@Override
	public void run() {
		
		
	}
	
	
}

public class MessengerClientApp {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("127.168.0.1", 9988); //198.168.0.105 127.0.0.1
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			while (true){
				String message = scanner.nextLine();		
				dos.writeUTF(message);		
				if ("quit".equals(message)){
					break;
				}
			}
			} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null ){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}if (scanner != null){
			scanner.close();
		}
	}
		
}

