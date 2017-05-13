package com.bigroi.classwork.lesson07;

public class ThreadSampleApp {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String curThreadName = currentThread.getName();
		System.out.printf("%s started\n", curThreadName);
		
		Thread counterThread0 = new CounterThread();
		counterThread0.start();
		
		Thread counterThread1 = new CounterThread();		
		counterThread1.start();
		
		System.out.printf("%s ended\n", curThreadName);
	}

}
