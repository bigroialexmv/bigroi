package org.alexkurets.lesson4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalyzerAnnotation {
	public static void parse(Class<?> cl) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		//Method[]meth = cl.getMethods();
		
		for(Method temp: cl.getDeclaredMethods())
		{
			
			for(Class<?> tempClass:temp.getParameterTypes())
			{
				System.out.println(tempClass.getName());
			}
			//if(temp.getName().equals("showMessage"))
				//temp.invoke(cl.newInstance(),null);
		}
	}
}
