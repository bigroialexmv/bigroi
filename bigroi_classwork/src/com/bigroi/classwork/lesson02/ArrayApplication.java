package com.bigroi.classwork.lesson02;

class ArrayUtil {
	
	static void swap(int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
	
	static int max(int[] a) {
		int m = a[0];
		for(int i = 0; i < a.length; i ++) { // i++ <-> i = i + 1
			if ( m < a[i] ) {
				m = a[i];
			}
		}
		return m; 
	}
	
	static int search(int[] a, int x) {
		int i = 0;
		for(int k = 0; k < a.length; k ++) { // i++ <-> i = i + 1
			if ( x == a[k] ) {
				i = k;
				break;
			}			
		}
		return i;
	}
	
	static void print(int[] a) {
		for(int i = 0; i < a.length; i ++) { // i++ <-> i = i + 1
			System.out.print( a[i] );
			System.out.print( " " );
		}
		System.out.println();
	}
	
	static int[] buildRandomArray(int length) {
		int[] a = new int[length];
		for(int i=0; i< length; i++) {
			a[i] = (int) Math.random();
		}
		return a;
	}
	
	static int[] buildRandomSotrtedArray(int length) {
		int[] a = new int[length];
		a[0] = 10;
		for(int i=1; i< length; i++) {
			a[i] = a[i-1] + Math.abs( (int) (Math.random()*100) ) + 1;
		}
		return a;
	}
	
	static int searchB(int[] a, int x) {
		int index = 0;
		
		int i = a.length / 2;
		
		int p = 0;
		int q = a.length;
		
		if (x < a[i] ) {
			
		} else if (x > a[i]) {
			
		}
		
		return index;
	}
			
}

public class ArrayApplication {

	public static void main(String[] args) {		
		
		int[] a = new int[] {-34, -22, -6, -4, -23, -44, -56, -48, -45};
		ArrayUtil.print(a);
		ArrayUtil.swap(a, 0, a.length - 1 );
		ArrayUtil.print(a);
		
		int max = ArrayUtil.max(a);
		System.out.println("max=" + max);
		
		int index = ArrayUtil.search(a, -4);
		System.out.println("index=" + index);
		
		a = ArrayUtil.buildRandomSotrtedArray(10);
		ArrayUtil.print(a);
		
		long l = 1000000000000000000L;
		long i = 0;
		while(i < l) {
			i ++;
		}
		
	}

}
