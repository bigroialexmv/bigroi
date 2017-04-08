package org.alexkurets.lesson3.addObject;

public class IAbstractClass1 extends AbstractClass1 {
	public IAbstractClass1(int x, String y)
	{
		super(x,y);
	}
	
	
	@Override
	public void method1() {
		System.out.println("method was called from IAbstractClass1");
	}
}
