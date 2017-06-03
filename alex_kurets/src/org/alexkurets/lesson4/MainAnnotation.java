package org.alexkurets.lesson4;

import java.lang.reflect.InvocationTargetException;

public class MainAnnotation {
	
	public static void main(String [] arg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		AnalyzerAnnotation.parse(TestClass.class);
	}

}
