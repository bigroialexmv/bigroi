package com.bigroi.samples.math;

public class HeronMethod {

	/*
	 * Вычисление квадратного корня числа x методом Герона
//	 * aprxm - approximation / приближение
	 * 
	 */
	public static double sqrt(double x, double aprxm, int n) {
		double nx = 0; 
		int i = n;
		while (i > 0) {
			nx = 0.5 * (aprxm + x / aprxm);
			aprxm = nx;
			System.out.println( (n - i + 1) + " " + aprxm );
			i --;
		}
		return nx;
	}
	
	public static void main(String[] args) {
		double x = 5;
		double r = HeronMethod.sqrt(x, x, 9);
		System.out.println("---------------");
		System.out.println("heron result = " + r);
		System.out.println("---------------");
		System.out.println("java  result = " + Math.sqrt(x) );
	}
}
