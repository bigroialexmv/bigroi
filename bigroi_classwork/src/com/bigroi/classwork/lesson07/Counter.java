package com.bigroi.classwork.lesson07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	
	// поскольку к полю count будут обращаться несколько потоков,
	// помечаем его ключевым словом volatile, чтобы избежать кэширования count, например, в кэше процессора
	// (разные потоки могут иметь свой кэш - т.е. разные 'версии' переменной count,
	// c volotile - чтение и запись будет осуществляться напрямую из памяти / в память)
	private volatile int count = 0;
	
	private Lock lock = new ReentrantLock();
	
	private Object lockingObject = new Object();
	
	public Counter() {
		
	}
	
	public int getCount() {
		return count;
	}
	
	protected void increment() {
		// первый поток, который получит лок путем вызова метода lock.lock(), продолжит свое выполнение
		// все остальные потоки остановятся на методе lock.lock() и будут ждать, пока первый поток не вызовет lock.unlock()
		// если мы подозреваем что между методами lock() и unlock() может произойти исключительная ситуация,
		//     	помещаем код между ними в блок try / catch
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

//  метод increment() помечается ключ. словом synchronized
//  первый поток, взвавший increment(), получит лок и будет выполнять increment(), 
// 		по окончании выполнения освободит лок для других потоков
//	остальные потоки будут ждать, пока первый не закончит выполнение increment()
//  synchronized работает медленнее - лучше использовать lock / unlock (!)
	
//	protected synchronized void increment() {
//			count = count + 1;
//			System.out.printf("%s: counter=%s\n", Thread.currentThread().getName(), count);
//			if (count == 5) {
//				throw new RuntimeException();
//			}
//	}


//	protected void increment() {
//		// то же самое, что и в случае synchronized increment()
//		// внутри метода можно использовать несколько блоков synchronized 
//		synchronized (lockingObject) {
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
				// поток остановит свое выполнение как минимум на 10 миллисекунд
				// (освободит процессор и даст возможность ОС выполнять другие потоки)
				Thread.sleep(10);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.printf("%s ended\n", threadName);
	}

}
