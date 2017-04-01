package org.lutsevich.lesson02;

public class Application2 {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;

		print(x, y);
		y = x;
		print(x, y);

		System.out.println();
		
		Integer xx = new Integer(2);
		Integer yy = new Integer(3);

		print(xx, yy);
		yy = xx;
		print(xx, yy);
	}

	private static void print(Integer x, Integer y) {
		System.out.println("x = " + x + ", y = " + y);

	}

}
