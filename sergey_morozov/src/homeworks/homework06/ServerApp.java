package homeworks.homework06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerApp {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9980);
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String dirName = dis.readUTF();
			File dirFile = new File(dirName);
			if (dirFile.exists()) {
				File [] list = dirFile.listFiles();
				for (File f : list) {
					System.out.println(f);
				}
			}
				String fileName = dis.readUTF();
				File file = new File(fileName);
				if (file.exists()) {
					try (FileInputStream reader = new FileInputStream (file)) {
						byte[] buffer = new byte[1024];
						int temp;
						while ((temp = reader.read()) != -1) {
							dos.write(buffer, 0, temp);
							
						   }
						dos.flush();
					
					}
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

				}
		}

			
	

