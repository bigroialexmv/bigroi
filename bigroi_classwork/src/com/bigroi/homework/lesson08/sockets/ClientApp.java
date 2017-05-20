package com.bigroi.homework.lesson08.sockets;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {

	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket("localhost", 9988);
		
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
		}
	}

}
