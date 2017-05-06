package com.bigroi.classwork.lesson06;

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
			in = new FileInputStream("D:\\test.tst");
			out = new FileOutputStream("D:\\test_copy.tst");
			byte[] buffer = new byte[10];
			
			int readCount = in.read(buffer, 0, 10);	
			while(readCount > 0) {
				out.write(buffer, 0, readCount) ;
				readCount = in.read(buffer);
			}
			
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			closeQuetly(in);
			closeQuetly(out);
		}

	}

	private static void closeQuetly(Closeable c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (IOException e) {				
			e.printStackTrace();
		}
	}

}
