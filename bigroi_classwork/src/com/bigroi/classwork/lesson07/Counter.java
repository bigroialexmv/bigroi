package com.bigroi.classwork.lesson07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	
	private volatile int count = 0;
	
	private Lock lock = new ReentrantLock();
	
	public Counter() {
		
	}
	
	public int getCount() {
		return count;
	}
	
	protected void increment() {
		lock.lock();		
		try {
			count = count + 1;
			System.out.printf("%s: counter=%s\n", Thread.currentThread().getName(), count);
			if (count == 5) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			lock.unlock();			
		}
		
	}

//	protected synchronized void increment() {
//		synchronized (this) {
//			count = count + 1;
//			System.out.printf("%s: counter=%s\n", Thread.currentThread().getName(), count);
//			if (count == 5) {
//				throw new RuntimeException();
//			}
//		}
//	}
//	
//	protected void increment() {
//		synchronized (lock) {
//			count = count + 1;
//		}
//	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s started\n", threadName);
		for(int i=0; i<10; i++) {
			increment();			
			//System.out.printf("%s: counter=%s\n", threadName, count);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.printf("%s ended\n", threadName);
	}

}
