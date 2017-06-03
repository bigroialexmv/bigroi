package org.alexkurets.lesson4;

@Deprecated
public class ClassC {
	private String str1;
	
	public ClassC(String str1) {
		super();
		this.str1 = str1;
	}

	//@Deprecated
	public String getString()
	{
		return this.str1;
	}
}
