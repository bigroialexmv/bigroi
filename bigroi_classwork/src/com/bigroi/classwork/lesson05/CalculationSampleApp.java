package com.bigroi.classwork.lesson05;

class DivisionByZeroException extends RuntimeException {
	
	public DivisionByZeroException() {
		super("Деление на 0");
	}
	
	public DivisionByZeroException(String message) {
		super(message);
	}
	
	public DivisionByZeroException(String message, Throwable e) {
		super(message, e);
	}
	
}

class ReminderNotZero extends Exception {
	
	private Integer op1;
	
	private Integer op2;
	
	public ReminderNotZero() {
		super("Остаток не 0");
	}
	
	public ReminderNotZero(String message) {
		super(message);
	}
	
	public ReminderNotZero(String message, Throwable e) {
		super(message, e);
	}
	
	public ReminderNotZero(int op1, int op2) {
		super("Отсаток от деления " + op1 + " на " + op2 + " не 0");
		this.op1 = op1;
		this.op2 = op2;
	}

	public Integer getOp1() {
		return op1;
	}

	public Integer getOp2() {
		return op2;
	}	
	
}

public class CalculationSampleApp {
	
	public static int div(int a, int b) throws DivisionByZeroException, ReminderNotZero {
		if ( b == 0) {
			DivisionByZeroException e = new DivisionByZeroException();
			throw e;
		}
		if (a % b != 0) {
			throw new ReminderNotZero(a, b);
		}
		if (b == 1) {
			throw new Error("Необязательное деление на 1");
		}
		return a / b;
	}
	
	private static void calc() throws ReminderNotZero {
		int c = div(20,1);
		System.out.println(c);
	}

	public static void main(String[] args) {		
//		try {
//			calc();
//		} catch (DivisionByZeroException e) {
//			System.out.println( e.getMessage() );
//		} catch (ReminderNotZero e) {
//			System.out.println( e.getMessage() );
//		}
		
		try {
			calc();
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}
	
}
