package com.bigroi.classwork.lesson04.s2;

import java.util.Arrays;

public class StandardArraySearcher implements ArraySearcher {

	@Override
	public int search(int[] a, int e) {		
		return Arrays.binarySearch(a, e);
	}

}
