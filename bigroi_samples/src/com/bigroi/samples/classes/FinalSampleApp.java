package com.bigroi.samples.classes;

/**
 * @author Alexander Medvedev
 *
 */

/**
 *  Класс FinalSamples объявлен с ключевым словом final - не может иметь классов-потомков 
 *
 */
final class FinalClass {	
	
}

class FinalSamples {	
	 
	/**
	 * Поле (или переменная), объявленное как final, не может менять значения после инициализации 
	 */
	final String finalFieldA = "This is finalFieldA";
	
	/**
	 * Поле finalField объявлено как final без инициализации, должно быть проинициализировано в конструкторе
	 * (не инициализируется null или 0 по умолчанию)
	 */
	final String finalFieldB;
	
	/**
	 * Поле, объявленное как static final, называется константой 
	 * Названия констант обычно пушутся большими буквами с разделяющим символом подчеркивания_
	 */
	public static final String CONSTANT_EXAMPLE = "This is a constant";
	
	public FinalSamples() {
		finalFieldB = "This is final field initialization";
	}
	
	/**
	 * Метод, объявленный с final, не может быть переопределен в классах-потомках 
	 */
	final void finalMethod() {
		System.out.println("Я всегда буду печатать это. Классы-потомки не смогут этого изменить");
	}
	
}

public class FinalSampleApp {
	
	public static void main(String[] args) {
		
	}

}
