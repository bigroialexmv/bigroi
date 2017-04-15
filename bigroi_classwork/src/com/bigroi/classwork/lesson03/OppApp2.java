package com.bigroi.classwork.lesson03;

class A {	
	void print() {
		System.out.println("print A");
	}
}

class B extends A {
	void print() {
		System.out.println("print B");
	}
}

public class OppApp2 {	
	public static void main(String[] args) {		
		A a = new A();
		B b = new B();
		
		a.print();
		b.print();
		
		A c = b;
		c.print();
		
	}

}
