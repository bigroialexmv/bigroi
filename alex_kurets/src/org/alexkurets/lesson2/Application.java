package org.alexkurets.lesson2;


public class Application {
	
	private static int x;
	private static int y=1;
	
	public void printVariables(){
		System.out.println(x);
		System.out.println(y);
	}
	
	public static void main(String[] args) {
		//Application ap = new Application();
		//ap.printVariables();
		
		Person alexKurets = new Person("Sasha","Kurets",29);
		Person michPupkin = new Person("Michael", "Pupkin",35);
		
		int age1=38;
		int age2=40;
		
		age1=age2;
		
		/*
		System.out.println(alexKurets.getFirstName());
		System.out.println(alexKurets.getLastName());
		System.out.println(alexKurets.getAge());
		
		System.out.println(michPupkin.getFirstName());
		System.out.println(michPupkin.getLastName());
		System.out.println(michPupkin.getAge());
		*/
		System.out.println("First call");
		
		alexKurets.print();
		michPupkin.print();
		
		System.out.println("Second call");
		alexKurets.setAge(100);
		michPupkin.setAge(100);
		
		alexKurets.print();
		michPupkin.print();
		
		System.out.println("Change objects alex->michael");
		alexKurets=michPupkin;
		alexKurets.print();
		michPupkin.print();
		
	}

}
