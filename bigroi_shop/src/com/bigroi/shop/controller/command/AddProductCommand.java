/**
 * 
 */
package com.bigroi.shop.controller.command;

import java.util.Scanner;

import com.bigroi.shop.dao.impl.ProductDaoFileImpl;
import com.bigroi.shop.model.Product;
import com.bigroi.shop.service.ProductService;
import com.bigroi.shop.service.impl.ProductServiceImpl;


/**
 * @author Alexander Medvedev
 *
 */
public class AddProductCommand extends Command {
	
	private ProductService productService;
	
	public AddProductCommand() throws Exception {
		this.productService = new ProductServiceImpl(new ProductDaoFileImpl("d:\\temp\\products.fdb"));
	}

	@Override
	public void execute(Scanner scanner) throws Exception {
		System.out.print("Enter product code: ");
		String code = scanner.nextLine();
		
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter product price: ");
		double price = Double.parseDouble( scanner.nextLine() );
		
		Product product = new Product(code, name, price);
		productService.saveProduct(product);
		
	}

}
