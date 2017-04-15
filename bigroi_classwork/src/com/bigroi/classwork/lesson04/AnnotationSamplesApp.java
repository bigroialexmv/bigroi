package com.bigroi.classwork.lesson04;

public class AnnotationSamplesApp {

	public static void main(String[] args) {
		User user = new User("Bob", 25);
		System.out.println("User: " + user);
		user.setAge(3);
		
		User user2 = new User("John", 12);
		System.out.println("User: " + user2);
		
		User user3 = new User("Bob", 12);
		System.out.println("User: " + user3);
		
		System.out.println( user.equals(user2) );
		System.out.println( user.equals(user3) );
	}
}
