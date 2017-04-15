package com.bigroi.classwork.lesson03;

public class StaticSamples {
	
	public static String STAT_CONST = "A1";
	
	public final static double PI = 3.14;
	
	public StaticSamples() {
		System.out.println("Contructor");
	}
	
	static {
		STAT_CONST = "BBBB";
		System.out.println("Static block");
	}

	public static void main(String[] args) {
		
//		StaticSamples o1 = new StaticSamples();
//		StaticSamples o2 = new StaticSamples();
//		
//		//StaticSamples.STAT_CONST = "B";
//		
//		System.out.println(StaticSamples.STAT_CONST);
//		System.out.println(StaticSamples.STAT_CONST);
		
	}
}
