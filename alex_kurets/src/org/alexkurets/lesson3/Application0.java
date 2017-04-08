package org.alexkurets.lesson3;

public class Application0 {
	int x;
	String name;
	final int constant;
	
	public Application0()
	{
		constant=0;
	}
	
	public Application0(String name){
		this();
		this.name=name;
	}
	
	public Application0(String name, int x)
	{
		this();
		this.x=x;
		this.name=name;
	}
	
	public Application0(int x, String name)
	{
		this();
		this.x=x;
		this.name=name;
	}
	
	
	public Application0(int x, String name, int temp)
	{
		this();
		this.x=x;
		this.name=name;
		//this.constant=constant;
	}
	
	
	
	public static void main(String[] args) {
			
		Application0 app0 = new Application0();
		System.out.println(app0.x);
		System.out.println(app0.name);
		
		
		char ch1 = 'x';
		System.out.println((char)(ch1+1));
		System.out.println(app0);
	}
	

}
