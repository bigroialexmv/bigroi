package com.bigroi.classwork.lesson03;

import java.util.ArrayList;
import java.util.List;

interface Printable {	
	void print();	
}

class ClassX implements Printable {	
	public void print() {
		System.out.println("I'm ClassX");	
	}	
}

class ClassY implements Printable {	
	public void print() {
		System.out.println("I'm ClassY");	
	}	
}

public class InterfaceSample {
	public static void main(String[] args) {
		
		Printable x = new ClassX();
		Printable y = new ClassY();
		x.print();
		y.print();
		
		
		
		List<Printable> list = new ArrayList<Printable>();
		list.add( new ClassX() );
		list.add( new ClassY() );
		
	}	
}
