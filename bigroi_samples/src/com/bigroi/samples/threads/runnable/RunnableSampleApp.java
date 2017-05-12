package com.bigroi.samples.threads.runnable;

public class RunnableSampleApp {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println(threadName + " started");
		
		Counter counter = new Counter();
		
		Thread thread1 = new Thread(counter, "Thread-Counter-1");
		Thread thread2 = new Thread(counter, "Thread-Counter-2");
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("counter = " + counter.getCount());
		System.out.println(threadName + " ended");
		
	}
}
