package org.alexkurets.lesson3.addObject;

public class IAbstractClass2 extends AbstractClass1 {
	public IAbstractClass2(int x, String y)
	{
		super(x,y);
	}
	
	@Override
	public void method1() {
		System.out.println("method was called from IAbstractClass2");
	}
}
