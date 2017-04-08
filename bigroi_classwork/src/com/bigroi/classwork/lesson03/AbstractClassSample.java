package com.bigroi.classwork.lesson03;

abstract class ClassA {
	private int x;
	ClassA() {		
	}
	ClassA(int x) {
		this.x = x;
	}
	void print () {
		System.out.println(x);
	}	
	abstract void method();
}

class ClassB extends ClassA {
	@Override
	void method() {		
		System.out.println("hi");
	}	
}

public class AbstractClassSample {

	public static void main(String[] args) {
		ClassA b = new ClassB();
	}
}
