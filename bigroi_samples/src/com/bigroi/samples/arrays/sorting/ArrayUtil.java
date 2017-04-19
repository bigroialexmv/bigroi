package com.bigroi.samples.arrays.sorting;

public class ArrayUtil {
	
	/**
	 * Создает массив случайных целых чисел
	 * 
	 * @param length - длина создаваемого массива
	 * @return массив случайных целых чисел
	 */
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for(int i=0; i< length; i++) {
			a[i] = (int) (Math.random() * 100000);
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
	
	/**
	 * Возвращает случайное целое число число от 1 до 101
	 * @return случайное целое число от 1 до 101
	 */
	public static int randomInt() {
		return Math.abs( (int) (Math.random()*1000) ) + 1;
	}
	
	/**
	 * Переставляет элементы с индексами i и j местами в массиве a 
	 * @param a массив целых чисел
	 * @param i	индекс
	 * @param j индекс
	 */
	public static void swap(int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
	
	public static int[] copyArray(int[] a) {
		int[] copy = new int[a.length];
		for(int i=0; i<a.length; i++) {
			copy[i] = a[i];
		}
		return copy;
	}
	
	public static int isSorted(int[] a) {
		int sortedUp = 1;
		int sortedDown = -1;
		for (int i = 1; i < a.length; i++) {
			if ( !(a[i-1] <= a[i]) ) {
				sortedUp = 0;
			}
			if ( !(a[i-1] >= a[i]) ) {
				sortedDown = 0;
			}			
		}
		if (sortedUp == 1) {
			return 1;
		}
		if (sortedDown == -1) {
			return -1;
		}
		return 0;
	}
	
//	public static int[] copyArray(int[] a) {
//		return copyArray(a);
//	}
	
	/**
	 * Находит индекс элемента x отсортированного по возрастанию массива a методом деления пополам
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
			if ( a[i] == x ) {
				return i;
			} else if ( a[i] > x ) {
				q = i;
			} else {
				p = i;
			}
		}
		
		if ( a[q] == x ) {
			return q;
		} else if ( a[p] == x ) {
			return p;
		}
		return -1;
	}
	
	public static void print(int[] a) {
		System.out.print("{");
		for(int i = 0; i < a.length - 1; i ++) { // i++   <=>   i = i + 1
			System.out.print( a[i] );
			System.out.print( ", " );
		}
		System.out.print( a[a.length - 1] );
		System.out.print("}");
	}
	
	public static void println(int[] a) {
		print(a);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] a = ArrayUtil.createRandomSotrtedArray(200);
		println(a);
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
