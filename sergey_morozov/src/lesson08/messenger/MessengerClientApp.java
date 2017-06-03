package lesson08.messenger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MessengerClientApp {

	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 9988);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			while(true) {
				String message = scanner.nextLine();
				dos.writeUTF(message);
				if ("quit".equals(message))
				break;
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
		if (scanner != null) {
			scanner.close();
		}

}
}
