package lesson08.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
//		if (dos == null) {
//			dos = new DataOutputStream( socket.getOutputStream() );
//		}
		return new DataOutputStream( socket.getOutputStream() );
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();		
			DataInputStream dis = new DataInputStream(is);
			name = dis.readUTF();
			System.out.println(name + " connected");
			while (true) {
				String message = dis.readUTF();				// читаем сообщение от клиента
				System.out.printf("Message recieved from %s: %s\n", name, message);
				if ("quit".equals(message)) {				// если клиент отправил quit выходим из цикла
					break;
				}
				messageListener.onMessage(this, message);
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
	
	private List<ServerClient> clients =
			Collections.synchronizedList( new ArrayList<ServerClient>() );
	
	public void onMessage(ServerClient from, String message) {	
		for(ServerClient client : clients) {
			if ( client.equals(from) ) continue;
			try {
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
			serverSocket = new ServerSocket(9988);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println( "Client connected: " + socket.getInetAddress() );
			
				ServerClient client = new ServerClient(socket, this);
				clients.add(client);
				
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

public class MessengerServerApp {	
	
	public static void main(String[] args) {		
		Server server = new Server();
		server.start();
	}

}
