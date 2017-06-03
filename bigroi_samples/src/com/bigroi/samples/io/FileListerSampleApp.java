package com.bigroi.samples.io;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileListerSampleApp {

	public static void main(String[] args) {
		PrintWriter writer = new PrintWriter( new OutputStreamWriter(System.out) );
		
		FileLister fileLister = new FileLister("c:\\Program Files\\Java");
		fileLister.list(writer);
	}
}
