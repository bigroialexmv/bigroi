package homeworks.homework03;

public class PerformanceMeasurer {
	
	private int executionsCount;
	
	public PerformanceMeasurer() {		
		this.executionsCount = 100;
	}

	public PerformanceMeasurer(int executionsCount) {
		
		this.executionsCount = executionsCount;
	}

	public long measure(Executable executable) {
		TimeMeasurer timeMeasurer = new TimeMeasurer();
		for (int i = 0; i < executionsCount; i++) {
			executable.execute();			
		}
		return timeMeasurer.getPassedMillis();
	}
	
	public long measureAndReport(Executable executable) {
		System.out.println("Выполняется " + executable);
		long timePassed = measure(executable);
		System.out.println("Время выполнения: " + timePassed);
		System.out.println("Количество выполнений: " + executionsCount);
		System.out.println();
		return timePassed;
	}
}