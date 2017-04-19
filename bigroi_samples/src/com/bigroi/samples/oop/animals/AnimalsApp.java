package com.bigroi.samples.oop.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalsApp {

	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<Animal>();
		
		animals.add( new Dog("Шарик") );
		animals.add( new Cat("Матроскин") );		
		animals.add( new Dog("Барбос") );
		
		for(int i=0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			animal.sayGreeting();
		}
		
	}

}
