package lesson07;

public class RunnableSampleApp {

	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread();
		String currentThreadName = currentThread.getName();
		System.out.printf("%s started\n", currentThreadName);
		
		Counter counter = new Counter();
		Thread counterThread0 = new Thread(counter);
		counterThread0.start();
		
		Thread counterThread1 = new Thread(counter);
		counterThread1.start();
		
		System.out.printf("%s ended\n", currentThreadName);


	}

}
