package com.bigroi.classwork.lesson06;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReaderSampleApp {

	public static void main(String[] args) {
		
		String fileName = "D:\\test.tst";
		InputStreamReader fileReader = null;
		BufferedReader reader = null;
		//Scanner reader = new Scanner(fileReader);
		try {
			fileReader = new FileReader(fileName);
			reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeQuetly(reader);
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
