package com.bigroi.classwork.lesson06.shop;

import java.io.Console;

public class ConsoleSampleApp {

	public static void main(String[] args) {
		Console c = System.console();
		System.out.println(c);
		c.readPassword("[%s]", "Password:");
	}

}
