package com.bigroi.classwork.lesson07;

public class RunnableSampleApp {
	
	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread();
		String curThreadName = currentThread.getName();
		System.out.printf("%s started\n", curThreadName);
		
		Counter counter = new Counter();
		
		Thread counterThread0 = new Thread(counter);
		counterThread0.setPriority(Thread.MIN_PRIORITY);
		counterThread0.start();
		
		counterThread0.setPriority(10);
		Thread counterThread1 = new Thread(counter);	
		counterThread1.setPriority(Thread.MAX_PRIORITY);
		counterThread1.start();
		
		try {
			System.out.printf("waiting for Thread-0\n");
			counterThread0.join();
			System.out.printf("Thread-0 finished\n");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		try {
			System.out.printf("waiting for Thread-1\n");
			counterThread1.join();
			System.out.printf("Thread-1 finished\n");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		System.out.printf("count=%s\n", counter.getCount());
		
		System.out.printf("%s ended\n", curThreadName);
	}		

}
