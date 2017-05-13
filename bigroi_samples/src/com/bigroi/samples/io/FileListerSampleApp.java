package com.bigroi.samples.io;

public class FileListerSampleApp {

	public static void main(String[] args) {
		System.out.println();
		FileLister fileLister = new FileLister(System.out);
		fileLister.list("c:\\Program Files\\Java");
	}
}
