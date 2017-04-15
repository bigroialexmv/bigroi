package com.bigroi.classwork.lesson04;

// @Range нельзя использовать для класса
class User /* extends Object*/ {	
	String name;
	
	@Range(min=12, max=99) int age;
	
	@Range(min=10, max=1000) int salary;
	
	public User(String name) {
		super();
		this.name = name;
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Deprecated
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * User переопределяет метод Object.toString()
	 * @Override - аннотация не обязательна
	 */
	@Override
	public String toString() {		
		return this.getName() + " {name: " + name + ", age: " + age + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof User) {
			User user = (User) obj;
			return this.name.equals( user.getName() );
		}
		return false;		
	}
	
}
