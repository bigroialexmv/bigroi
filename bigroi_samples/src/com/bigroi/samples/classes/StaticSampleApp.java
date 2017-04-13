/**
 * 
 */
package com.bigroi.samples.classes;

class StaticMembersSample {
	
	/**
	 * Объявление с инициализацией статического поля staticFieldA 
	 * Поле инициализируется при первом обращении к классу (к конструктору либо статическому члену класса - методу или полю)
	 * Статическое поле используется на уровне класса (одно для всех объектов класса)
	 * Для обращения к staticFieldA не требуется созавать объект
	 */
	static String staticFieldA = "This is static field 1";
	
	/**
	 * Объявление без инициализация статического поля staticFieldB 
	 * По умолчанию staticFieldB проинициализируется значением null
	 */
	static String staticFieldB;
	
	/** 
	 * Статический блок 
	 * 	1) Выполняется при первом обращении к классу (один раз за все время выполнения программы)
	 * 	2) Выполняется до обращения к каким-либо членам класса (полям, методам, конструкторам)
	 * 	3) Внутри статического блока нельзя обращаться к нестатическим членам класса 
	 * 			(т.е. к объявленным без использования static)
	 * 	4) Может обращаться к статическим членам класса 
	*/
	static {
		System.out.println("Вызвался static-блок 1");
		staticFieldB = "This is static field 2";
	}
	
	/**
	 * Не статическое поле nonstaticField, не может быть использовано в статическом блоке 
	 */
	String nonstaticField;
	
	public StaticMembersSample() {
		System.out.println("Вызвался конструктор StaticMembersSample");
		nonstaticField = "This is non-static field";
	}
	
	/** 
	 * Статический блок 2 
	 *	Инициализирует статическую переменную staticField2
	*/
	static {
		System.out.println("Вызвался static-блок 2");
		staticMethod();
	}
	
	/**
	 * Статический метод
	 * Может напрямую обращаться только к статическим членам класса (другим статическим методам или полям)
	 */
	static void staticMethod() {
		System.out.println("Вызвался статический метод staticMethod()");
	}
	
}

/**
 * @author Alexander Medvedev
 *
 */
public class StaticSampleApp {

	public static void main(String[] args) {
		System.out.println("Создается staticFields1");
		StaticMembersSample staticFields1 = new StaticMembersSample();
		
		System.out.println("Создается staticFields2");
		StaticMembersSample staticFields2 = new StaticMembersSample();
		
		// Пример обращения к статическому полю: ИмяКласса.поле 
		System.out.println( "StaticMembersSample.staticFieldB = " + StaticMembersSample.staticFieldB );
		
		// Пример обращения к статическому методу: ИмяКласса.метод()
		StaticMembersSample.staticMethod();
	}
}
