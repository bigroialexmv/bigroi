package com.bigroi.lesson01.cycles;

public class ForExample {

	public static void main(String[] args) {
		/* 
		double[] prices = new double[4];
		prices[0] = 10;
		prices[1] = 20;
		prices[2] = 30;
		prices[3] = 40;
		*/
		
		double[] prices = new double[] {10, 20, 30, 40, 50, 60, 70};
		
		double totalPrice = 0;
		for(int i = 0; i < prices.length; i++) {
			totalPrice = totalPrice + prices[i];
		}
		
		System.out.println("totalPrice=" + totalPrice);
	}

}
