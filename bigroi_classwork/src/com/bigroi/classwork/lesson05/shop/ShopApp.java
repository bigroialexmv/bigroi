package com.bigroi.classwork.lesson05.shop;

import java.util.Scanner;

public class ShopApp {
	
	static ProductService productService = new ProductServiceMockImpl();

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		//String userInput = scanner.nextLine();
		
		while (true) {
			System.out.print("Enter command: ");
			String userCommand =  scanner.nextLine();
			if ( "quit".equals( userCommand ) ) {
				break;
			} else if ("addp".equals( userCommand )) {
				System.out.print("Enter product code: ");
				String code = scanner.nextLine();
				
				System.out.print("Enter product name: ");
				String name = scanner.nextLine();
				
				System.out.print("Enter product price: ");
				double price = scanner.nextDouble();
				
				Product product = new Product(code, name, price);
				productService.saveProduct(product);
			} else {
				System.out.println("Invalid command");
			}
		}	
		
		scanner.close();
		
		Product p = productService.findProductByCode("001");
		System.out.println( p );
		System.out.print("Program exited");
	}
}
