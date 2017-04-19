/**
 * 
 */
package com.bigroi.samples.arrays.sorting;

import java.util.ArrayList;
import java.util.List;

import com.bigroi.samples.execution.PerformanceMeasurer;

/**
 * @author Alexander Medvedev
 *
 */
public class ArraySortApplication {

	public static void main(String[] args) {
		int[] a = ArrayUtil.createRandomArray(1000000);
		
		List<ArraySorter> arraySorters = new ArrayList<ArraySorter>();
		arraySorters.add( new StandardSorter() );
//		arraySorters.add( new BubbleArraySorter() );
		arraySorters.add( new QuckSortArraySorter() );
		arraySorters.add( new MixedSortArraySorter() );
		
		PerformanceMeasurer measurer = new PerformanceMeasurer(100);
		for(ArraySorter arraySorter : arraySorters) {
			SortExecutor sortExecutor = new SortExecutor( arraySorter, a );
			sortExecutor.executeAndReport(false);
			measurer.measureWithReport(sortExecutor);
		}
		
	}
}
