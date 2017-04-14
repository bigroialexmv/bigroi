/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

/**
 * @author Alexander Medvedev
 *
 */
public class MixedArraySorter extends AbstractArraySorter {
	
	BubbleArraySorter bubbleArraySorter = new BubbleArraySorter();
	
	public MixedArraySorter() {
		super("Смешанная сортировка");
	}
	
	
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public void sort(int a[], int lo, int hi) {
		if ( !(lo < hi) ) {
			return;
		}
		int i = lo - 1;
		int j = hi + 1;
		int pi = (i + j) >>> 1;
		int p = a[pi];
			
		while (i < j) {
			do {
				i ++;
			} while ( a[i] < p );
			do {
				j --;
			} while ( a[j] > p );
			if (i < j) {
				// swap(a, i, j);
				int x = a[i];
				a[i] = a[j];
				a[j] = x;
			}
		}
		if (j - lo <= 45) {
			bubbleArraySorter.sort(a, lo, j);
		} else {
			sort(a, lo, j);
		}
		
		if (hi - j <= 45) {
			bubbleArraySorter.sort(a, j + 1, hi);
		} else {
			sort(a, j + 1, hi);
		}
		
	}	

}
