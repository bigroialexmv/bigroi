package com.bigroi.classwork.lesson03;

public class ClassSample {
	
	int x;
	
	String name;
	
	final String finalName;
	
	public ClassSample() {	
		finalName = "final value";
	}
	
	public ClassSample(String name) {
		// this(name, 0);
		finalName = "final value";
		System.out.println(finalName );
		System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
		this.name = name;
	}
	
	public ClassSample(String name, int a) {
		this();
		System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
		this.name = name;
	}
	
	public ClassSample(int a, String name) {
		this();
		System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		ClassSample p = new ClassSample();
		
		System.out.println(p.x);
		System.out.println(p.name);
		
		ClassSample p1 = new ClassSample("Name 1");
		System.out.println(p1.x);
		System.out.println(p1.name);
		
		ClassSample p3 = new ClassSample("Name 2", 2);
		
		ClassSample p4 = new ClassSample(2, "Name 2");
		
	}

}
