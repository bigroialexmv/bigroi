/**
 * 
 */
package com.bigroi.samples.execution;

/**
 * @author Alexander Medvedev
 *
 */
public class PerformanceMeasurer {
	
	private int executionsCount;
	
	public PerformanceMeasurer() {
		this(1000);
	}
	
	public PerformanceMeasurer(int executionsCount) {
		this.executionsCount = executionsCount;
	}
	
	public int getExecutionsCount() {
		return executionsCount;
	}	

	public long measureWithReport(final Executable executable) {
		System.out.println();
		System.out.println( "Измеряется " + executable );
		long millisPassed = this.measure(executable);
		System.out.println( "Время выполнения: " + millisPassed + " (мсек.)" );
		System.out.println( "Количество выполнений: " + getExecutionsCount() );
		return millisPassed;
	}
	
	public long measure(final Executable executable) {		
		final TimeMeasurer timeMeasurer = new TimeMeasurer();
		for (int i = 0; i < executionsCount; i++) {
			executable.execute();
		}
		return timeMeasurer.getMillisPassed();
	}

}
