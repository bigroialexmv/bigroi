package com.bigroi.classwork.lesson07;

import java.util.Scanner;

class Worker implements Runnable {

	@Override
	public void run() {		
		synchronized (this) {
			while(true) {			
				try {
					this.wait();
					System.out.println("Piece of work done");
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
			}			
		}
				
	}
	
}

public class WaitNotifySampleApp {	
	
	public static void main(String[] args) {
		
		Worker worker = new Worker();
		Thread workerThread = new Thread(worker);
		workerThread.setDaemon(true);
		
		Scanner s = new Scanner(System.in);
		while (true) {
			String cmd = s.nextLine();
			if( "q".equals( cmd ) ) {
				break;
			} else if( "n".equals( cmd ) ) {
				synchronized (worker) {
					worker.notify();
					System.out.println("notified");
				}				
			}
		}
		System.out.println("main ended");
		s.close();
		
	}

}
