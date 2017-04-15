package com.bigroi.classwork.lesson04.s2;

import java.util.ArrayList;
import java.util.List;

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
		int[] a = createRandomSortedArray(100000);
		int e = 858;
	
		List<ArraySearcher> searchers = new ArrayList<ArraySearcher>();		
		searchers.add( new LinearArraySearcher() );
		searchers.add( new BinaryArraySearcher() );
		
		PerformanceMeasurer measurer = new PerformanceMeasurer(10000);		
		for(ArraySearcher searcher : searchers) {		
			ArraySearchExecutor executor = new ArraySearchExecutor(searcher, a, e);
			measurer.measureAndReport(executor);
		}
		
		
	}
}
