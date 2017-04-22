package com.bigroi.classwork.lesson05.shop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Scanner;

public class ShopApp {
	
	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductServiceMockImpl();		

		InputStreamReader reader = new FileReader("D:\\products_1.fdb");		
		readInput(productService, new Scanner( reader ));
		
		System.out.println();
		readInput(productService, new Scanner( System.in ));
		
		FileWriter writer = new FileWriter("D:\\products_1.fdb");
		Collection<Product> products = productService.findAllProducts();
		for(Product p : products) {
			writer.write("addp");
			writer.write("\n");
			writer.write(p.getCode());
			writer.write("\n");
			writer.write(p.getName());
			writer.write("\n");
			writer.write( p.getPrice().toString() );
			writer.write("\n");			
		}
		writer.write("quit");
		writer.write("\n");
		writer.close();	
		System.out.println();		
		System.out.print("Program exited");
	}

	private static void readInput(ProductService productService, Scanner scanner) throws Exception {
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
				double price = Double.parseDouble( scanner.nextLine() );
				
				Product product = new Product(code, name, price);
				productService.saveProduct(product);
			} else if ("showp".equals( userCommand ) ) {
				System.out.print("Enter product code: ");
				String code = scanner.nextLine();
				Product p = productService.findProductByCode(code);
				System.out.println( p );
			} else {
				System.out.println("Invalid command");
			}
		}
		scanner.close();
	}
}
