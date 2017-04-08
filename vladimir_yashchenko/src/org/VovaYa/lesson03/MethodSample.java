package org.VovaYa.lesson03;

class Point{
	int x;
	int y;
	Point (int x, int y)
	this.x = x;
	this.y = y;
	
}

public class MethodSample {
	
	static int x =10;

	static void method1(){
		System.out.println("method1");
		x =  3;
	}
	static void changePoit(Point p){
		p.x = p.x +3;
	}
	
	
	static int changeX (int x){
		x = x + 3;
		return x;
	}
	
	
	
	public static void main(String[] args) {
		method1();
		MethodSample.method1();
		
		int x = 5;
		x = changeX(50);
		System.out.println(x);
		
		Point p = new Point(10, 10);
		changePoit(p);
		System.out.println("p.x = " + p.x);

	}

}
