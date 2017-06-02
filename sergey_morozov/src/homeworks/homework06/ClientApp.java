package homeworks.homework06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClientApp {

		
	public static void main(String[] args) {
		Socket socket = null;
		String dirName = "E:\\Install";
		String fileName = "D:\\HashMap.txt";
		String receivedFile = "E:\\HashMap.txt";
		File file = new File(receivedFile);
		try {
			socket = new Socket("localhost", 9980);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			dos.writeUTF(dirName);	
			dos.flush();
			dos.writeUTF(fileName);
			dos.flush();
			
			try (FileOutputStream writer = new FileOutputStream(file)) {
				byte [] buffer = new byte[64*1024];
				int temp;
				int i = 0;
				while ((temp = dis.read(buffer)) != -1) {
					writer.write(buffer,i,temp);
					i+=temp;
				   }
				
			}
			dis.close();
			dos.close();
			
			
			
		
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

