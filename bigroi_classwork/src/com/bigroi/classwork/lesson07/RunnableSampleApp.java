package com.bigroi.classwork.lesson07;

public class RunnableSampleApp {
	
	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread();
		String curThreadName = currentThread.getName();
		System.out.printf("%s started\n", curThreadName);
		
		// предварительно создаем класс Counter, "наследуем" его от интерфейса java.lang.Runnable
		// реализуем метод run() из интерфейса java.lang.Runnable
		
		// создаем экземпляр класса Counter
		Counter counter = new Counter();
		
		// Создаем экземпляр класса Thread, в конструктор передаем экземпляр класса Counter 
		Thread counterThread0 = new Thread(counter);
		
		// необязательно: устанавливаем приоритет выполнения потока, MIN_PRIORITY - минимальный приоритет
		// ОС (операционная система будет стараться выделять больше процессорного времени другим потокам)
		counterThread0.setPriority(Thread.MIN_PRIORITY);
		
		// запускаем поток, после запуска потока будет вызван метод run() объекта counter
		counterThread0.start();
		
		
		Thread counterThread1 = new Thread(counter);	
		counterThread1.setPriority(Thread.MAX_PRIORITY);
		counterThread1.start();
		
		try {
			System.out.printf("waiting for Thread-0\n");
			// вызываем join() у потока counterThread0, чтобы дождаться окончания выполнения потока counterThread0 
			// текущий поток main приостановится и будет ждать пока не выполнится метод counter.run() в потоке counterThread0
			counterThread0.join();
			System.out.printf("Thread-0 finished\n");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		try {
			System.out.printf("waiting for Thread-1\n");			
			// текущий поток main приостановится и будет ждать пока не выполнится метод counter.run() в потоке counterThread1
			counterThread1.join();
			System.out.printf("Thread-1 finished\n");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		System.out.printf("count=%s\n", counter.getCount());
		
		System.out.printf("%s ended\n", curThreadName);
	}		

}
