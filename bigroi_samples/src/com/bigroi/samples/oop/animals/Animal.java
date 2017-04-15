/**
 * 
 */
package com.bigroi.samples.oop.animals;

/**
 * @author Alexander Medvedev
 * 
 * Animal является абстракным классом, не может быть использован для создания объектов
 * 
 */

public abstract class Animal {
	
	private String name;
	
	private String nickname;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public Animal(String name, String nickname) {
		this.name = name;
		this.nickname = nickname;
	}
	
	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}
	
	protected String buildGreeting() {
		return String.format("Привет, я %s, меня зовут %s", name, nickname);
	}

	public void sayGreeting() {
		String greeting = buildGreeting();
		System.out.println( greeting ); 
	}
}
