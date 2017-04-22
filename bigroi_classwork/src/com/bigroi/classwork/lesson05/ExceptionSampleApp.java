package com.bigroi.classwork.lesson05;

import java.util.Scanner;

public class ExceptionSampleApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		
		int num = 0;
		while (true) {
			System.out.println("Введите число: ");
			String str = scanner.nextLine();
			try {
				num = Integer.parseInt(str);
				System.out.println("Вы ввели число: " + num);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Ошибка, неверное число: " + str + ". Повторите ввод");
			}
		}
		System.out.println("Программа завершена");
		scanner.close();
	}
}
