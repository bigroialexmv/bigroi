/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

/**
 * @author Alexander Medvedev
 *
 */
public abstract class AbstractArraySorter implements ArraySorter {
	
	private String description;
	
	public AbstractArraySorter() {		
	}
	
	public AbstractArraySorter(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	protected void swap(int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
}
