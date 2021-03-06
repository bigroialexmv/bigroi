package lesson06;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFilesSampleApp {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
	try {
		in = new FileInputStream("D:\\BIGROI_1366x768.jpg");
		out = new FileOutputStream("D:\\BIGROI_1366x768_copy.jpg");
		byte[] buffer = new byte[10];
		
		int readCount = in.read(buffer, 0, 10);
		
		while (readCount > 0 ) {
		out.write(buffer, 0, readCount);
		readCount = in.read(buffer);
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		closeQuetly(in);
		closeQuetly(out);
	}

	}

	public static void closeQuetly(Closeable c) {
		try {
			if (c != null)
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
