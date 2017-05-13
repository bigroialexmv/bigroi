package com.bigroi.classwork.lesson07;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class Timer implements Runnable {
	
	private AtomicBoolean doWork = new AtomicBoolean(true);
	
	void stop() {
		doWork.set(false);
	}

	@Override
	public void run() {
		while ( doWork.get() ) {
			long time = System.currentTimeMillis();
			Date date = new Date(time);
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			String formatedDate = DATE_FORMAT.format(date);
			System.out.println(formatedDate);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class TimerSampleApp {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Thread timerThread = new Thread( timer );
		//timerThread.setDaemon(true);
		timerThread.start();
		
		//timerThread.
		
		Scanner s = new Scanner(System.in);
		while (true) {
			String cmd = s.nextLine();
			if( "q".equals( cmd ) ) {
				timer.stop();
				break;
			}
		}
		System.out.println("main ended");
		s.close();
	}

}
