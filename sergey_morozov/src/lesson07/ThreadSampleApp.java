package lesson07;

public class ThreadSampleApp {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String currentThreadName = currentThread.getName();
		System.out.printf("%s started\n", currentThreadName);
		
		Thread counterThread0 = new CounterThread();
		counterThread0.start();
		
		Thread counterThread1 = new CounterThread();
		counterThread1.start();
		System.out.printf("%s ended\n", currentThreadName);

	}

}
