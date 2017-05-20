package com.bigroi.homework.lesson08.messenger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MeessengerClientApp {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);

		try {
			socket = new Socket("192.168.0.100", 9988);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
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
