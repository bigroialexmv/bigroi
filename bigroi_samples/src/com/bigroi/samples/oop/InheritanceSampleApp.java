/**
 * 
 */
package com.bigroi.samples.oop;

/**
 * @author Alexander Medvedev
 *
 */

/**
 *	Класс, объявленный с ключевым словом abstract, не может быть использован для создания объектов 
 *	Может содержать абстрактные методы (методы без реализации)
 *	Parent по умолчанию наследуется от класса Object (java.lang.Object)
 */

abstract class Parent {
	
	String name;
	
	public Parent(String name) {
		this.name = name;
		System.out.println("Вызвался конструктор Parent(String name)");
	}
	
	/**
	 * Абстрактный метод, его должны реализовывать потомки
	 * Если класс-потомок не реализует хотя бы один абстрактный метод, то он тоже должен быть объявлен как abstract
	 * (т.е. тоже будет абстракным классом) 
	 */
	abstract public void printMe();
}

class Child extends Parent {
	
	public Child(String name) {
		super(name); // вызывается конструктор класса-родителя Parent(String name)
		System.out.println("Вызвался конструктор Child(String name)");
		
	}
	
	/**
	 * Класс Child переопределил (реализовал) абстрактный метод printMe()
	 */
	public void printMe() {
		System.out.println("Я Child");
	}
	
	/**
	 *  Класс Child переопределил метод toString() - метод, объявленный в классе Object,
	 */
	public String toString() {
		return "class Child {name=" + name + "}";
	}
	
}


public class InheritanceSampleApp {
	
	public static void main(String[] args) {
		Parent a = new Child("Класс-потомок");
		System.out.println( a ); // в println можно передвавть любой объект, внутри будет вызываться метод toString()
								 // и результат выполнения to String выводиться в консоль 
	}

}
