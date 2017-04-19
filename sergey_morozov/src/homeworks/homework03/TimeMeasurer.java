package homeworks.homework03;

public class TimeMeasurer {
	
	private long startTime;

	public TimeMeasurer() {
		this.startTime = System.currentTimeMillis();
	}
	
	public long getPassedMillis() {
		long currentTime = System.currentTimeMillis();
		return (currentTime - startTime);
	}
	

}
