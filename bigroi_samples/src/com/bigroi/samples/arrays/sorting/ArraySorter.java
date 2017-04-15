/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

/**
 * @author Alexander Medvedev
 *
 */
public interface ArraySorter {
	
	public String getDescription();
	
	public void sort(int a[]);
	
	public void sort(int a[], int lo, int hi);

}
