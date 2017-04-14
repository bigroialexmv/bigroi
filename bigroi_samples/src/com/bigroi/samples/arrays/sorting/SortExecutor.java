/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

import com.bigroi.samples.execution.Executable;

/**
 * @author Alexander Medvedev
 *
 */
public class SortExecutor implements Executable {
	
	private ArraySorter sorter;
	
	private int[] array;
	
	private int[] sortedArray;
	
	public SortExecutor(ArraySorter sorter, int[] array) {
		super();
		this.sorter = sorter;
		this.array = array;
	}

	@Override
	public void execute() {
		int[] a = copyArray(array);
		sorter.sort(a);
		sortedArray = a;
	}
	
	public void executeWithReport() {
		execute();
		printReport(true);
	}
	
	public void executeWithReport(boolean printArrays) {
		execute();
		printReport(printArrays);
	}

	public void printReport(boolean printArrays) {
		System.out.println();
		System.out.println(sorter.getDescription());
		if (printArrays) {
			System.out.print( "Исходный массив:           " );
			ArrayUtil.println(array);
			System.out.print( "Отсортрованный массив:	   " );
			ArrayUtil.println( sortedArray );
		}
		System.out.println( "Проверка: " + ( ArrayUtil.isSorted(sortedArray) == 0 ? "Ошибка" : "ОК" ) );
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + ":" + sorter.getClass().getName() + " - " + sorter.getDescription();
	}
	
	protected int[] copyArray(int[] a) {
		int[] copy = new int[a.length];
		for(int i=0; i<a.length; i++) {
			copy[i] = a[i];
		}
		return copy;
	}

}
