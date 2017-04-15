package com.bigroi.classwork.lesson04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// указывает, что аннатацию Range можно использовать только для полей
// @Target(value=ElementType.TYPE) // только для типов
public @interface Range {

	public int min() default 0;
	public int max() default 100;
	
}
