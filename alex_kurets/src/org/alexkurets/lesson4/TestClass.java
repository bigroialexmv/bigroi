package org.alexkurets.lesson4;

public class TestClass {
	int number;
	String name;
	
	
	public TestClass()
	{
		
	}
	
	public TestClass(int number, String name)
	{
		this.number=number;
		this.name=name;
	}
	
	
	public int getInt()
	{
		return number;
	}
	
	
	public String getString()
	{
		return this.name;
	}
	
	
	public void showMessage(String str1)
	{
		System.out.println(str1);
	}
}
