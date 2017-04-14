/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

import java.util.Arrays;

/**
 * @author Alexander Medvedev
 *
 */
public class StandardSorter implements ArraySorter {
	
	@Override
	public void sort(int[] a) {
		Arrays.sort(a);		
	}

	@Override
	public void sort(int[] a, int lo, int hi) {
		Arrays.sort(a, lo, hi);
	}
	
	@Override
	public String getDescription() {		
		return "Сортировка Java API Arrays.sort()";
	}

}
