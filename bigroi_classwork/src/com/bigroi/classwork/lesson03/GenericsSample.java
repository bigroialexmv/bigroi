package com.bigroi.classwork.lesson03;

import java.util.HashMap;
import java.util.Map;

public class GenericsSample<T> {
	
	private T a;
	
	public GenericsSample(T a) {
		super();
		this.a = a;
	}

	public T getA() {
		return a;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		GenericsSample<String> s = new GenericsSample<String>("string");
		System.out.println( s.getA() );
		
		GenericsSample<Integer> i = new GenericsSample<Integer>(10);
		System.out.println( i.getA() );
	}

}
