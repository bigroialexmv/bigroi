package com.bigroi.classwork.lesson02;

public class Person {

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	public Person(String fName, String lName, int age) {
		firstName = fName;
		lastName = lName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void print() {
		System.out.print( getFirstName() );
		System.out.print( " " );
		System.out.print( getLastName() );
		System.out.print( " " );
		System.out.println( getAge() );
	}
}
