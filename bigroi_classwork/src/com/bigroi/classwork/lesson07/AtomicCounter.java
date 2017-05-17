package com.bigroi.classwork.lesson07;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Runnable {
	
	private AtomicInteger count = new AtomicInteger(0);

	public int getCount() {
		return count.get();
	}
	
	protected void increment() {
		count.getAndAdd(1);
	}

	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s started\n", threadName);
		for(int i=0; i<10000; i++) {
			increment();			
			//System.out.printf("%s: counter=%s\n", threadName, count);			
		}
		System.out.printf("%s ended\n", threadName);
	}

}
