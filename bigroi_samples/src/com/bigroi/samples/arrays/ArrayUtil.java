package com.bigroi.samples.arrays;

public class ArrayUtil {
	
	/**
	 * Создает массив случайных целых чисел
	 * 
	 * @param length - длина создаваемого массива
	 * @return массив целых чисел
	 */
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for(int i=0; i< length; i++) {
			a[i] = (int) (Math.random() * 100 );
		}
		return a;
	}
	
	/**
	 * Создает случайный массив целых чисел, отсортированный по возрастанию
	 * 
	 * @param length - длина создаваемого массива
	 * @return массив целых чисел, расположенных по возрастанию
	 */
	public static int[] createRandomSotrtedArray(int length) {
		int[] a = new int[length];
		a[0] = randomInt();
		for(int i = 1; i < length; i++) {
			a[i] = a[i-1] + randomInt();
		}
		return a;
	}
	
	public static int randomInt() {
		return Math.abs( (int) (Math.random()*100) ) + 1;
	}
	
	/**
	 * Находит индекс элемента x отсортированного массива a методом деления пополам
	 * 
	 * @param a - массив целых чисел
	 * @param x - искомый элемент массива
	 * @return
	 */
	public static int search(int[] a, int x) {
		int p = 0;
		int q = a.length - 1;
		int i = 0;
		
		while ( (q - p) > 1 ) {
			i = p + (q - p) / 2;
			if (a[i] == x) {
				return i;
			} else if ( a[i] > x ) {
				q = i;
			} else {
				p = i;
			}
		}
		
		if (a[q] == x) {
			return q;
		} else if (a[p] == x) {
			return p;
		}
		return -1;
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i ++) { // i++  i = i + 1
			System.out.print( a[i] );
			System.out.print( " " );
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] a = ArrayUtil.createRandomSotrtedArray(20);
		print(a);
		int x = a[15];
		
		System.out.println("searching for " + x);
		int i = ArrayUtil.search(a, x);
		System.out.println("result = " + i);
		
		x = a[0];
		System.out.println("searching for " + x);
		i = ArrayUtil.search(a, x);
		System.out.println("result = " + i);
		
		x = a[a.length - 1];
		System.out.println("searching for " + x);
		i = ArrayUtil.search(a, x);
		System.out.println("result = " + i);
		
	}

}
