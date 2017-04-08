package org.alexkurets.lesson3.addObject;

public class PathX {
	
	protected double distance;
	private double x0;
	private double x;
	
	public PathX(double x0, double x) {
		super();
		this.x0 = x0;
		this.x = x;
	}
	
	
	public void setPoint(double x)
	{
		this.x=x;
	}
	
	public double getDistance()
	{
		distance = x-x0;
		return this.distance;
	}

}
