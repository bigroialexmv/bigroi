/**
 * 
 */
package com.bigroi.samples.execution;

/**
 * @author Alexander Medvedev
 *
 */
public class TimeMeasurer {

	private long creationTime;
	
	public TimeMeasurer() {
		creationTime = System.currentTimeMillis();
	}
	
	public long getMillisPassed() {
		long currentTime = System.currentTimeMillis();
		return (currentTime - creationTime);
	}
	
	public long getSecondsPassed() {
		return getMillisPassed() / 1000;
	}
	
	@Override
	public String toString() {
		return "Прошло " + getMillisPassed() + " миллисекунд";
	}
	
}
