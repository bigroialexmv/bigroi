package com.bigroi.homework.lesson03;

public class LinearArraySearcher implements ArraySearcher {

	@Override
	public int search(int[] a, int e) {
		for (int i = 0; i < a.length; i++) {
			if ( a[i] == e) {
				return i;
			}
		}
		return -1;
	}

}
