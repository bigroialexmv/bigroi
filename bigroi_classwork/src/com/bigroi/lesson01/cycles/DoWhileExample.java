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
		
		// Печатает числа массива типа int[], кратные трем
		int[] a = new int[] {3, 5, 6, 9, 11, 15, 21, 22};
		int j = -1;
		
		do {
			j ++;					// (1)
			
			if (j == a.length)
				break;				// выход из цикла - переход к строке (2)
			
			int x = a[j];
			
			if ( (a[j] % 3) != 0 )
				continue;			// переход в начало цикла - к строке (1)	
			
			System.out.println(x);
			
		} while (true);
									// (2)
	}
}
