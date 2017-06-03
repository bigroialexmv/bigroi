package lesson08;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		System.out.println("Server started");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9988);
			Socket socket = serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			int a = is.read();
			System.out.println("Received: " + a);
			
			System.out.println("Client connected: " + socket.getInetAddress());
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
