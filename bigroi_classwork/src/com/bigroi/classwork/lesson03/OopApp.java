package com.bigroi.classwork.lesson03;

import java.util.ArrayList;
import java.util.List;

class PathX /*extends Object*/ {
	
	protected Double distance;
	private double x0;
	private double x;
	
	public PathX() {		
	}
	
	public PathX(double x0) {		
		this.x0 = x0;
	}
	
	public double getDistance() {
		System.out.print("PathX.getDistance");
		return sub(x, x0);
	}
	
	protected double sub(double a, double b) {
		return (a - b);
	}

	public double getX() {
		return x;
	}
	
	public double getX0() {		
		return x0;
	}

	public void setX(double x) {
		this.x = x;
	}	
}

class PathXY extends PathX {
	
	double y;
	
	double y0;

	public PathXY(double x0, double y0) {
		super(x0); //		this.x = x;
		this.y0 = y0;
		//System.out.println( distance );
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public double getDistance() {
		System.out.print("PathXY.getDistance");
		double dX = sub(getX(), getX0());
		double dY = sub(y, y0);
		return Math.sqrt( Math.pow(dX, 2) + Math.pow(dY, 2) );
	}

	
	
}

public class OopApp {
	
	public static void main(String[] args) {
		PathX pathX = new PathX(2);		
		pathX.setX(10);
		//System.out.println( pathX .getDistance() );
		
		PathXY pathXY = new PathXY(0, 0);
		pathXY.setX(3);
		pathXY.setY(4);
		//System.out.println( pathXY.getDistance() );
		
		//PathX px = pathXY;
		
		List<PathX> list = new ArrayList<PathX>();
		list.add( new PathX(4) );
		list.add( new PathXY(3,4) );
		list.add( new PathXY(3,4) );
		list.add( new PathX(4) );
		
		for (int i = 0; i < list.size(); i++) {
			PathX p = list.get(i);
			System.out.println( p.getDistance() );
		}
		
	}
}
