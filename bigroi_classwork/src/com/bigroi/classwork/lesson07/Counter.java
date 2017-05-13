package com.bigroi.classwork.lesson07;

public class Counter implements Runnable {
	
	private int count = 0;
	
	public int getCount() {
		return count;
	}

	protected void increment() {
		count = count + 1;		
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s started\n", threadName);
		for(int i=0; i<100000; i++) {
			increment();
			//System.out.printf("%s: counter=%s\n", threadName, count);
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {				
//				e.printStackTrace();
//			}
		}
		System.out.printf("%s ended\n", threadName);
	}

}
