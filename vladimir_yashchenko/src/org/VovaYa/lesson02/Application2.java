package org.VovaYa.lesson02;

public class Application2 {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		
		print(x, y);
		x = y;
		print(x, y);
		 System.out.println();
		
		Integer xx = new Integer(2);
		Integer yy = new Integer(3);
		print(xx, yy);
		yy = xx;
		print(xx, yy);
		

	}

	private static void print(int x, int y) {
		System.out.println("x = " + x + ", y = " + y);
		
	}

}
