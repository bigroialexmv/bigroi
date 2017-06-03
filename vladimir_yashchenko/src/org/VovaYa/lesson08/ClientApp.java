package org.VovaYa.lesson08;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientApp {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9988);
			OutputStream os = socket.getOutputStream();
			os.write(55);
			os.flush();//передаём 55 на сервер
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
		}
	}
		
}

