package org.alexkurets.lesson4;

public class Main {
	public static void main(String arg[])
	{
		ClassA objb = new ClassB();
		IInterfaceA temp = objb;
		System.out.println(objb instanceof ClassB);
		System.out.println(objb.getClass());
		
		
		ClassC c = new ClassC("test string");
		
		System.out.println(c.getString());
	}
}
