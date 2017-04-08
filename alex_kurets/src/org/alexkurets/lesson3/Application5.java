package org.alexkurets.lesson3;

import java.util.ArrayList;
import java.util.List;

import org.alexkurets.lesson3.addObject.AbstractClass1;
import org.alexkurets.lesson3.addObject.IAbstractClass1;
import org.alexkurets.lesson3.addObject.IAbstractClass2;

public class Application5 {
	
	public static void main(String[] args) {
		
		List<AbstractClass1> list1 = new ArrayList<>();
		list1.add(new IAbstractClass1(12, "First implement"));
		list1.add(new IAbstractClass2(15, "First implement"));
		
		for(AbstractClass1 temp : list1)
		{
			temp.method1();
		}
	}
		
}
