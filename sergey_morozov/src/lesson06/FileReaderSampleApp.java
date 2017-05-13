package lesson06;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderSampleApp {

	public static void main(String[] args) {
		String fileName = "D:\\test.txt";
		BufferedReader reader = null;
		InputStreamReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			reader = new BufferedReader(fileReader);
			String line = reader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			closeQuetly(reader);
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
