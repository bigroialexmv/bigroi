package com.bigroi.classwork.lesson04.s2;

public class BinaryArraySearcher implements ArraySearcher {

	@Override
	public int search(int[] a, int e) {		
		int p = 0;
		int q = a.length - 1;
		
		if (a[p] == e) return 0;
		if (a[q] == e) return q;
		
		while (q - p > 1) {
			int i = (p + q) / 2;
			if (a[i] == e) {
				return i;
			}
			if (a[i] < e) {
				p = i;
			} else {
				q = i;
			}
		}
		
		return -1;
	}

}
