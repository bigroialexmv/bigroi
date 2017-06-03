package com.bigroi.samples.threads.thread;

public class ThreadSampleApp {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println(threadName + " started");
		
		CounterThread counterThread1 = new CounterThread();
		CounterThread counterThread2 = new CounterThread();
		counterThread1.start();
		counterThread2.start();
		
		System.out.println( "counter 1 = " + counterThread1.getCount() );
		System.out.println( "counter 2 = " + counterThread2.getCount() );
		
		try {
			counterThread1.join();
			counterThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = counterThread1.getCount() + counterThread2.getCount();
		
		System.out.println( "total = " + total );
		 
		System.out.println(threadName + " ended");
	}
}
