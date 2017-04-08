package org.lutsevich.lesson02;

public class Application {

	public static void main(String[] args) {
		Person p1 = new Person("Bob", "Smith", 30);
		Person p2 = new Person("John", "Doe", 40);

		p1.print();
		p2.print();

		p1.setAge(35);
		p1.setAge(45);

		p1 = p2;

		p1.setAge(65);

		p1.print();
		p2.print();

		int age1 = 30;
		int age2 = 40;
		
		Person p3 = p1;
		System.out.println("p3");
		p3.print();

		age2 = age1;
		age1 = 75;
		System.out.println("age1 = " + age1);
		System.out.println("age2 = " + age2);

		// System.out.println(p1.getFirstName());
		// System.out.println(p1.getAge());

		// System.out.println(p2.getFirstName());
		// System.out.println(p2.getAge());

	}

}
