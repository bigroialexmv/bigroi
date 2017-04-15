package com.bigroi.classwork.lesson04;

public enum WeekDay {
	
	MONDAY("Понедельник", 1),
	TUESDAY("Вторник", 2),
	WEDNESDAY("Среда", 3),
	THURSDAY("Четверг", 4),
	FRIDAY("Пятница", 5);
	
	String name;
	int order;
	
	WeekDay(String name, int order) {
		this.name = name;
		this.order = order;
	}
}
