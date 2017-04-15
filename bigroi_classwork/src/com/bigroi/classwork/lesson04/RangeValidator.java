package com.bigroi.classwork.lesson04;

import java.lang.reflect.Field;

public class RangeValidator {
	
	public String validate(User user) {		
		String error = null;
		Class<?> userClass = User.class;
		Field[] fields = userClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			Range range = f.getAnnotation(Range.class);
			boolean hasRangeAnnotation = (range != null);
			System.out.println( f.getName() + " has range annotation: " + hasRangeAnnotation);
			if (hasRangeAnnotation) {
				if ( (user.getAge() <= range.max() ) && (user.getAge() >= range.min()) ) {					
				} else {
					error = "Ошибка, поле " + f.getName()+  " должно быть в диапозоне " +
							range.min() + "..." + range.max();
							
				}
			}
		}
		return error;
	}
}
