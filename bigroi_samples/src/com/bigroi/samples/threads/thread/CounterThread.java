package com.bigroi.samples.threads.thread;

public class CounterThread extends Thread {
	
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	public void incrementCount() {
		count = count + 1;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started");
		for(int i=0; i < 10; i++) {
			incrementCount();
			System.out.println(threadName + ": counter=" + count);
		}
	}
	
}
