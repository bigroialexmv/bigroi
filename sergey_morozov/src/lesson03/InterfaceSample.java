package lesson03;

import java.awt.List ;
import java.util.ArrayList;
import java.util.TreeSet;

interface Printable {
	void print();
}

class IA implements Printable {

	@Override
	public void print() {
		System.out.println("I'm IA");
		
	}
}
	class IB implements Printable {

		@Override
		public void print() {
			System.out.println("I'm IB");
			
		}
}

public class InterfaceSample {

	public static void main(String[] args) {
		
		Printable a = new IA();
		Printable b = new IB();
		a.print();
		b.print();
		
		ArrayList<Printable> list = new ArrayList<Printable>();
		TreeSet<String> set = new TreeSet<String>();
		set.add("abc");
		set.add("xyz");
		set.add("aaa");
		set.add("wasd");
		
		//System.out.println(set.first());
		for (String s : set) {
			System.out.println(s);
		}
	}
}

