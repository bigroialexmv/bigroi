/**
 * 
 */
package com.bigroi.samples.exceptions;

import java.util.Scanner;

/**
 * @author Alexander Medvedev
 *
 */

/*
 (1) Throwable								
 
 (2) Error (extends Throwable)				- ошибка (+ все потомки), обычно не проверяется в программе

 (3) Exception (extends Throwable)			- checked (обязательно проверяемое) исключение (+ все потомки)

 (4) RuntimeException (extends Exception) 	- unchecked (не обязательно проверяемые) исключение (+ все потомки)

 (5) Ключевые слова try / catch / finally 	- для выполнения блока операторов и обработки исключений, которые могут произойти в блоке 
 
 (6) Ключевое слово throw 					- для генерации исключения / ошибок
 
 (7) Ключевое слово throws 					- указывается при описании метода со списком исключений, 
 											которые должны быть проверены (обработаны) при вызове метода
*/

class CalculationException extends Exception {	// SampleException - checked, проверяемое исключение

	private static final long serialVersionUID = -5435178406915377752L;
	
	public CalculationException() {
		super();				// Вызывает конструктор по умолчанию класса Exception
	}
	
	public CalculationException(String message) {
		super(message); 		// Вызывает конструктор класса Exception: public Exception(String message)
	}
	
	public CalculationException(String message, Throwable cause) {
		super(message, cause); 	// Вызывает конструктор класса Exception: public Exception(String message, Throwable cause)
	}
	
}

class SampleRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
}

public class ExceptionSampleApp {
	
	public static String SUM_ERR_FORMAT = "%s операнд %s не является числом";
	
	public static int calcExpression(String expression) throws CalculationException {
		String[] tokens = expression.split(" ");
		int op1 = 0;
		int op2 = 0;
		
		try {
			op1 = Integer.parseInt( tokens[0] );
		} catch (NumberFormatException e) { // NumberFormatException является unchecked (наследуется от RuntimeException) - catch не обязателен
			String message = String.format(SUM_ERR_FORMAT, "1-ый", tokens[0] );
			throw new CalculationException( message , e);
		}
		
		try {
			op2 = Integer.parseInt( tokens[2] );
		} catch (NumberFormatException e) {
			String message = String.format(SUM_ERR_FORMAT, "2-ой", tokens[2] );
			throw new CalculationException( message , e);
		}
		
		String operator = tokens[1];
		switch (operator) {
			case "+": 
				return (op1 + op2);
			case "-":
				return (op1 - op2);
			case "*":
				return (op1 * op2);
			case "/":
				return (op1 / op2);
		}
		throw new CalculationException("Неизвестный опратор: " + operator);
	}
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);		// Используем класс Scanner для удобства 
		
		System.out.println("Введите выражение (пример: 3 + 6 ):");
		String input = scanner.nextLine();
			
		try {
			int result = calcExpression (input);
			System.out.println(input +  " = " + result);
		} catch (CalculationException e) {	// CalculationException является checked (наследуется от Exception) - catch обязателен
			System.out.println("Произошла ошибка: " + e.getMessage());
		} catch (ArithmeticException e) {   // ArithmeticException является unchecked - catch не обязателен
			System.out.println("Произошла арифметическая ошибка: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Произошла непредвиденная ошибка");
			e.printStackTrace();
		} finally {
			scanner.close();
			System.out.println("Сканнер закрыт");
		}
		System.out.println("Программа завершена");
		
	}
}
