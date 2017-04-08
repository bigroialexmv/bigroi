package com.bigroi.classwork.lesson03;

import java.util.Iterator;
import java.util.TreeSet;

class ElemIterator implements Iterator<Integer> {
	
	ElemCollection col;
	
	int i = 0;

	public ElemIterator(ElemCollection col) {
		super();
		this.col = col;
	}

	@Override
	public boolean hasNext() {
		boolean next = (i < col.nextIndex);		
		return next;
	}

	@Override
	public Integer next() {
		Integer e = col.store[i];
		i ++;
		return e;
	}
	
}

class ElemCollection implements Iterable<Integer> {	
	
	Integer[] store = new Integer[10];
	
	int nextIndex = 0;	
	 
	public void add(Integer e) {
		 store[nextIndex] = e;
		 nextIndex ++;
	}
	
	public Iterator<Integer> iterator() {
		return new ElemIterator(this);
	}	
	
}

public class TreeSetApp {
	
	public static void main(String[] args) {
		
		int[] a = new int[] {2,4,5,6,7};
		
		for(int x : a) { 			// for(int i=0; i<a.length; i++) {
			System.out.println(x);	// 		System.out.println(a[i])
		}							// }
		
		ElemCollection col = new ElemCollection();
		col.add(50);
		col.add(10);
		col.add(40);
		col.add(30);
		for (Integer i : col) {
			System.out.println(i);
		}
	}

	/*
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		set.add("axc");
		set.add("abc");
		set.add("xyz");
		set.add("aaa");
		set.add("zaa");
		
		//System.out.println(set.first());
		for(String s : set) {
			System.out.println(s);
		}		
		
	} */
}
