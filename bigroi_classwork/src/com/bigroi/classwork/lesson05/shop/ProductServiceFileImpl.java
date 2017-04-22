package com.bigroi.classwork.lesson05.shop;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class ProductServiceFileImpl implements ProductService, Closeable {
	
	private PrintWriter writer;
	
	public ProductServiceFileImpl(String fileName) throws FileNotFoundException {
		writer = new PrintWriter(fileName);
	}

	@Override
	public Product findProductByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		writer.write( product.toString() );	
		writer.write( "\n" );
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		writer.close();		
	}

	@Override
	public Collection<Product> findAllProducts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
