package homeworks.homework03;

import java.util.ArrayList;
import java.util.List;

import homeworks.homework02.ArraySorter;
import homeworks.homework02.BubbleArraySorter;


public class ArraySorterApp {

		
		static int[] createRandomArray(int length) {
			int[] a = new int[length];		
			for (int i = 0; i < a.length; i++) {
				a[i] = getRandomInteger();
			}
			return a;
		}
		
		static int getRandomInteger() {
			double randomDouble = Math.random() * 1000;
			//System.out.println("randomDouble = " + randomDouble);		
			int result = (int) randomDouble;
			//System.out.println("result = " + result);
			return result;
		}
		
		static void print(int[] a) {
			for (int i = 0; i < a.length - 1; i++) {
				System.out.print( a[i] + ", ");
			}
			System.out.println( a[a.length - 1] );
		}

		public static void main(String[] args) {
			
			int[] a = createRandomArray(1000);
			
			List<ArraySorter> sorters = new ArrayList<ArraySorter>();		

			sorters.add( new BubbleArraySorter() );
			sorters.add( new StandartArraySorter() );
			
			PerformanceMeasurer measurer = new PerformanceMeasurer(10000);		
			for(ArraySorter sorter : sorters) {		
				SortExecutor executor = new SortExecutor(sorter, a);
				measurer.measureAndReport(executor);
}

}
}
