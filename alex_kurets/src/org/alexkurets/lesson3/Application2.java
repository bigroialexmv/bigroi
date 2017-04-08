package org.alexkurets.lesson3;

public class Application2 {
	int x=0;
	
	
	public static void method1(){
		System.out.println("method1");
		//this.x=100;	ошибка метод с static
	}
	
	
	
	public static void main(String[] args) {
		method1();
	}
}
