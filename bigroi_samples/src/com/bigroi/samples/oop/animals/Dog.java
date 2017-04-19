/**
 * 
 */
package com.bigroi.samples.oop.animals;

/**
 * @author Alexander Medvedev
 *
 */
public class Dog extends Animal {
	
	public Dog(String nickname) {
		super("cобака", nickname);
	}
	
	@Override
	protected String buildGreeting() {
		String greeting = super.buildGreeting();
		return greeting + ". Гав!";
	}
	
}
