package com.bigroi.classwork.lesson07;

import java.util.Scanner;

class Worker implements Runnable {

	private Object waitNotify;	
	
	public Worker(Object waitNotify) {
		this.waitNotify = waitNotify;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for notification");
				synchronized (waitNotify) {
					waitNotify.wait();
					System.out.println("Piece of work done");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class WaitNotifySampleApp {	
	
	public static void main(String[] args) {
		
		Object waitNotify = new Object();
		
		Worker worker = new Worker(waitNotify);
		Thread workerThread = new Thread(worker);
		workerThread.setDaemon(true);
		workerThread.start();
		
		Scanner s = new Scanner(System.in);
		while (true) {
			String cmd = s.nextLine();
			if( "q".equals( cmd ) ) {
				break;
			} else if( "n".equals( cmd ) ) {
				synchronized (waitNotify) {
					waitNotify.notify();					
				}
				System.out.println("notified");
			}
		}
		System.out.println("main ended");
		s.close();
		
	}

}
