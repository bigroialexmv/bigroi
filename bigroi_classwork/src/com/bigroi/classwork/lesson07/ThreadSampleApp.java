package com.bigroi.classwork.lesson07;

public class ThreadSampleApp {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String curThreadName = currentThread.getName();
		System.out.printf("%s started\n", curThreadName);
		
		// для запуска нового потока создаем класс CounterThread
		// наследуем его от класса java.lang.Thread
		// в классе CounterThread переопределяем метод run()		
		Thread counterThread0 = new CounterThread();
		
		// по вызову метода start() - сообщаем JVM / опрерационной системе, что поток готов к запуску
		// при запуске потоке вызовется переопределtнный метод counterThread0.run()
		counterThread0.start();
		
		Thread counterThread1 = new CounterThread();		
		counterThread1.start();
		
		System.out.printf("%s ended\n", curThreadName);
	}

}
