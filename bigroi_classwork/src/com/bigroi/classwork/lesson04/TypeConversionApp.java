package com.bigroi.classwork.lesson04;

interface X {	
}

class ClassA {
	void ma() { System.out.println("Выполнился ma()"); };
}

class ClassB extends ClassA implements X {
	void mb() {};
}

class ClassC extends ClassB {
	void mc() { System.out.println("Выполнился mc()"); };
}

public class TypeConversionApp {
	
	static void call(ClassA obj) {
		obj.ma();
		
		System.out.println(obj.getClass().getSimpleName() + ": " + (obj instanceof ClassC) );		
		// (obj instanceof C) -> true, если a является экземпляром класса С
		if ( (obj instanceof ClassC) ) {
			ClassC z = (ClassC) obj;
			z.mc();
		}
	}

	public static void main(String[] args) {
		ClassC c = new ClassC();
		call (c);		
		
		System.out.println(" --- ");
		ClassA a = new ClassA();
		call (a);
	}

}
