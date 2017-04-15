/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

/**
 * @author Alexander Medvedev
 *
 */
public class BubbleArraySorter extends AbstractArraySorter {
	
	public BubbleArraySorter() {
		super("Сортировка пузырьком");
	}
	
	public void sort(int a[]) {
		final int n = a.length;
		int i = 1;
		int j = 0;
		
		while ( i < n) {
			j = i;
			while ( (j > 0) && (a[j] < a[j-1]) ) {
				swap(a, j, j-1);
				j --;
			}
			i ++;
		}
	}
	
	public void sort(int a[], int lo, int hi) {
		final int n = hi;
		int i = lo + 1;
		int j = 0;
		
		while ( i <= n) {
			j = i;
			while ( (j > 0) && (a[j] < a[j-1]) ) {
				swap(a, j, j-1);
				j --;
			}
			i ++;
		}
	}

}
