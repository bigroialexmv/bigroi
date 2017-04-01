package org.alexkurets.lesson2;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String adress;
	
	public Person(String fName, String lname, int age){
		this.firstName=fName;
		this.lastName=lname;
		this.age=age;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}

	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public void print(){
		System.out.println(firstName+lastName+" has"+" age:"+age);
	}
	
}
