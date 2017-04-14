/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

/**
 * @author Alexander Medvedev
 *
 */
public class QuckSortArraySorter extends AbstractArraySorter {
		
	public QuckSortArraySorter() {
		super("Быстрая сортировка");
	}
	
	public  void sort(int a[]) {
		sort(a, 0, a.length - 1);		
	}
	
	public void sort(int a[], int lo, int hi) {
		if ( !(lo < hi) ) {
			return;
		}
		int i = lo - 1;
		int j = hi + 1;
		int pi = (i + j) / 2;
		int p = a[pi];
			
		while (i < j) {
			do {
				i ++;
			} while ( a[i] < p );
			do {
				j --;
			} while ( a[j] > p );
			if (i < j) {
				swap(a, i, j);				
			}
		}
		sort(a, lo, j);
		sort(a, j + 1, hi);
	}	

}
