package lesson07;

public class CounterThread extends Thread {
	
	private int count = 0;
	protected void increment() {
		count = count + 1;
		System.out.printf("%s: counter = %s\n", getName(), count);
	}
	
	@Override
	public void run() {
		System.out.printf("%s started\n", Thread.currentThread());
		for (int i  = 0; i < 100; i++){
			increment();
			}
		System.out.printf("%s ended\n", Thread.currentThread());
		
	}

}
