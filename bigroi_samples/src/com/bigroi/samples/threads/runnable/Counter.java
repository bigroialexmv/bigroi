package com.bigroi.samples.threads.runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	
private int count = 0;

	Lock lock = new ReentrantLock();
	
	public int getCount() {
		return count;
	}
	
	public /*synchronized*/ void incrementCount() {
		lock.lock();
		count = count + 1;
		//lock.unlock();
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started");
		for(int i=0; i < 1000; i++) {
			incrementCount();
		}
	}

}
