package com.bigroi.classwork.lesson05.shop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Scanner;

public class ShopApp {
	
	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductServiceMockImpl();		

		// создаем объект file, в конструкторе указываем путь к файлу, с которым хотим работать
		File file = new File("C:\\WORKSPACE\\products_1.fdb"); /* (1) */
		boolean fileExists = file.exists(); 
		if ( fileExists ) {	// если файл существует
			// создаем объект reader, который умеет читать данные из файла
			InputStreamReader reader = new FileReader( file );
			// создаем Sanner и передаем в него reader, 
			// объект scanner будет исрользовать методы reader-a при вызове scanner.nextLine() 
			Scanner scanner = new Scanner(reader);
			
			// вызов метода readInput в конечном итоге считывает строки из файла C:\WORKSPACE\products_1.fdb
			// создает и добавляет объекты Product в поле-мапу codeProductMap, хранимое в объекте productService
			readInput( productService, scanner );
		}
		
		System.out.println();
		
		// поле System.in (является объектом интерфейса InputStream) используем для создания сканера,
		// считывающего данные, вводимые пользователем из консоли
		
		Scanner scanner = new Scanner( System.in );
		// считываем команды и данные из консоли, создаем объекты Product и добавляем их в поле codeProductMap (в объекте productService)
		readInput(productService, scanner);
		
		// Сохраняем в файл построчно поля объектов класса Product, а также комманды, которые затем будут использоваться
		// при новом запуске приложения в (1) (чтобы использовать один и тот же метод - readInput - как для консольного ввода, 
		// так и для чтения комманд из файла)
		FileWriter writer = new FileWriter("C:\\WORKSPACE\\products_1.fdb");
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
		// 
		
		System.out.println();		
		System.out.print("Program exited");
	}

	/**
	 * C помощью Scanner читает команды и данные, вводимые пользователем из консоли, либо из файла
	 * (в зависимости от того как был создан scanner)
	 * @param productService
	 * @param scanner
	 * @throws Exception
	 */
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
				System.out.println("Invalid command. Commands available: addp, showp or quit");
			}
		}
		scanner.close();
	}
}
