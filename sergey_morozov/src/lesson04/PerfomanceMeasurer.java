package lesson04;

public class PerfomanceMeasurer {
	private int executionsCount;
	

	public PerfomanceMeasurer() {
		this.executionsCount = 100;
	}


	public long measure (Executable executable) {
		TimeMeasurer timeMeasurer = new TimeMeasurer ();
		for (int i = 0; i < executionsCount; i++){
			executable.execute();
		}
		return timeMeasurer.getPassedMillis();
		
	}
	
	public long measureAndReport (Executable executable) {
		System.out.println("Выполняется " + executable);
		long timePassed = measure(executable);
		
		System.out.println("Количество выполнений: " + executionsCount);
		return timePassed;
	}
}
