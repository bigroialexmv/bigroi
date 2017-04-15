package com.bigroi.classwork.lesson04.s1;

public class ArraySearcherApp {
	
	static int[] createRandomSortedArray(int length) {
		int[] a = new int[length];
		a[0] = getRandomInteger();
		for (int i = 1; i < a.length; i++) {
			a[i] = a[i-1] + getRandomInteger() + 1;
		}
		return a;
	}
	
	static int getRandomInteger() {
		double randomDouble = Math.random() * 1000;
		//System.out.println("randomDouble = " + randomDouble);		
		int result = (int) randomDouble;
		//System.out.println("result = " + result);
		return result;
	}
	
	static void print(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print( a[i] + ", ");
		}
		System.out.println( a[a.length - 1] );
	}

	public static void main(String[] args) {
		
		//System.out.println( getRandomInteger() );
		
		
//		int[] a = new int[] {10, 11, 80, 87, 88, 89, 96, 128, 144, 169, 170, 191, 203, 230, 237, 271, 373, 380, 404, 451, 532, 538, 546, 565, 594, 594, 620, 630, 641, 669, 678, 692, 712, 730, 765, 770, 781, 814, 839, 840, 858, 862, 880, 886, 922, 925, 943, 945, 990, 991};
		//int[] a = new int[] {10, 11, 80, 87, 88, 89, 96, 128, 144, 169, 170};
		int[] a = createRandomSortedArray(100000); 
		//print(a);
		
		
		ArraySearcher searcher = new LinearArraySearcher();
		
		TimeMeasurer timeMeasurer = new TimeMeasurer();
		
		int executionsCount = 100000;
		int index = 0;
		for(int i=0; i < executionsCount; i++) {
			int e = 858;
			index = searcher.search(a, e);
		}
		
		long timePassed = timeMeasurer.getPassedMillis();
		System.out.println("Результат: " + index + "\nВремя выполнения: " + timePassed + 
				"\nКоличество выполнений: " + executionsCount);
		System.out.println();
		
		TimeMeasurer timeMeasurer2 = new TimeMeasurer();
		searcher = new BinaryArraySearcher();
		for(int i=0; i < executionsCount; i++) {
			int e = 858;
			index = searcher.search(a, e);
		}
		timePassed = timeMeasurer2.getPassedMillis();
		System.out.println("Результат: " + index + "\nВремя выполнения: " + timePassed + 
				"\nКоличество выполнений: " + executionsCount);
		System.out.println();
		
	}
}
