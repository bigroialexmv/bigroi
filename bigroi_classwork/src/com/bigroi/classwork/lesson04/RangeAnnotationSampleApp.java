package com.bigroi.classwork.lesson04;

public class RangeAnnotationSampleApp {

	public static void main(String[] args) {
		User user = new User("Bob", 23);
		RangeValidator validator = new RangeValidator();
		String error = validator.validate(user);
		if (error != null) {
			System.out.println( error );
		}
		
		User user2 = new User("John", 10);
		error = validator.validate(user2);
		if (error != null) {
			System.out.println( error );
		}
	}

}
