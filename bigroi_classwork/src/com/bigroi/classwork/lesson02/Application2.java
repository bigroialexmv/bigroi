package com.bigroi.classwork.lesson02;

public class Application2 {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		
		print(x, y);
		y = x;				
		print(x, y);
		
		System.out.println();
		
		Integer xx = new Integer(2); 
		//Integer xx = 2;
		//String x = "sdsd";
		Integer yy = new Integer(3); // = 13
		
		print(xx, yy);
		yy = xx;
		xx = 5;
		print(xx, yy);
		
	}

	private static void print(Integer x, Integer y) {
		System.out.println( "x=" + x + ", y = " + y );
	}

}
