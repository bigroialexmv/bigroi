package org.alexkurets.lesson3;

import org.alexkurets.lesson3.addObject.Class1WithStatic;;

public class Application1 {
	
	public static void main(String[] args) {
		Class1WithStatic obj1 = new Class1WithStatic();
		//obj1.var1=100000;
		Class1WithStatic obj2 = new Class1WithStatic();
		
		System.out.println("obj1.var1="+Class1WithStatic.VAR1);
		System.out.println("obj2.var1="+Class1WithStatic.VAR1);
		
	}

}
