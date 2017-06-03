package org.alexkurets.homework3;

public class TimeMesaure {
	private long startTime;
	
	public TimeMesaure()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	public long getPasseMillis()
	{
		return System.currentTimeMillis()-this.startTime;
	}

}
