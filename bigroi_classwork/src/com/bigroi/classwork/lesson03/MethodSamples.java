package com.bigroi.classwork.lesson03;

class Point {
	int x;
	int y;
	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
}

public class MethodSamples {
	
	static int x = 10;
	
	static void method1() {
		System.out.println("method1" );	
		x = 3;
	}
	
	static double change (double x, double y) {
		x = x + 3;
		return x;
	}
	
	static double change (double x) {
		x = x + 3;
		return x;
	}
	
	static void changePoint(Point q) {
		q.x = q.x + 3;
	}	

	public static void main(String[] args) {
		method1();
		MethodSamples.method1();
		
		double x = 5;
		double y = x + Math.sqrt(4);
		change ( x );
		
		System.out.println(x);
		
		Point p = new Point(10, 10);
		changePoint( p );
		
		System.out.println("p.x=" + p.x);
	}
}
