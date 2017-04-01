package com.bigroi.lesson01.cycles;

public class DoWhileExample {
	
	public static void main(String[] args) {
		
		double[] prices = new double[3];
		prices[0] = 10;
		prices[1] = 20;
		prices[2] = 30;
		
		double totalPrice = 0;
		int i = 0;
		do {
			totalPrice = totalPrice + prices[i];
			i = i + 1;
		} while(i < prices.length);
		
		System.out.println("totalPrice=" + totalPrice);

	}
}
