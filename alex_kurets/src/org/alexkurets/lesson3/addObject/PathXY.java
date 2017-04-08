package org.alexkurets.lesson3.addObject;

public class PathXY extends PathX {
	private double y0,y;
	
	public PathXY(double x0,double x, double y0, double y)
	{
		super(x0,x);
		this.y0=y0;
		this.y=y;
	}
	
	@Override
	public double getDistance()
	{
		System.out.println("Override method");
		distance = Math.sqrt((y-y0)+super.getDistance());
		return distance;
	}
	
	public void tempMethod()
	{
		System.out.println("Method from PathXY");
	}
	
	
}
