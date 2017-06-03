package lesson07;

public class Counter implements Runnable {

	private int count = 0;
	
	private static Object lock = new Object();
	
	Counter() {
		
	}
	
	public int getCount(){
	 	return count;
	}
	
	protected void increment() {
		synchronized(lock) {
		count = count + 1;
		System.out.printf("%s: counter = %s\n", Thread.currentThread(), count);
	}
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s started\n", threadName);
		for (int i  = 0; i < 100; i++){
			increment();
			System.out.printf("%s: counter = %s\n", threadName, count);
			}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.printf("%s ended\n", threadName);
		
	}
}
