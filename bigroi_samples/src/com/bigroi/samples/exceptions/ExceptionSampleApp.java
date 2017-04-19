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

class SumCalculationException extends Exception {	// SampleException - checked, проверяемое исключение

	private static final long serialVersionUID = -5435178406915377752L;
	
	public SumCalculationException() {
		super();				// Вызывает конструктор по умолчанию класса Exception
	}
	
	public SumCalculationException(String message) {
		super(message); 		// Вызывает конструктор класса Exception: public Exception(String message)
	}
	
	public SumCalculationException(String message, Throwable cause) {
		super(message, cause); 	// Вызывает конструктор класса Exception: public Exception(String message, Throwable cause)
	}
	
}

class SampleRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
}

public class ExceptionSampleApp {
	
	public static String SUM_ERR_FORMAT = "%s слагаемое %s не является числом";
	
	public static int calcSum(String a, String b) throws SumCalculationException {
		int intA = 0;
		int intB = 0;
		
		try {
			intA = Integer.parseInt(a);
		} catch (NumberFormatException e) { // NumberFormatException является unchecked (наследуется от RuntimeException) - catch не обязателен
			String message = String.format(SUM_ERR_FORMAT, "1-ое", a);
			throw new SumCalculationException( message , e);
		}
		
		try {
			intB = Integer.parseInt(b);
		} catch (NumberFormatException e) {
			String message = String.format(SUM_ERR_FORMAT, "2-ое", b);
			throw new SumCalculationException( message , e);
		} finally {
			System.out.println("  { Выполнился finally блок } ");
		}
		
		return (intA + intB);
	}
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);		// Используем класс Scanner для удобства 
		
		System.out.println("Введите 1-ое слагаемое:");
		String a = scanner.next();
		
		System.out.println("Введите 2-ое слагаемое:");
		String b = scanner.next();
		
		System.out.println("Введите делитель:");
		String c = scanner.next();
		
		try {
			int result = calcSum (a, b) / Integer.parseInt(c);
			System.out.println("a + b = " + result);
		} catch (SumCalculationException e) {	// CalculationException является checked (наследуется от Exception) - catch обязателен
			System.out.println("Произошла ошибка: " + e.getMessage());
		} catch (ArithmeticException e) {   // ArithmeticException является unchecked - catch не обязателен
			System.out.println("Произошла арифметическая ошибка: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Произошла непредвиденная ошибка");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}
}
