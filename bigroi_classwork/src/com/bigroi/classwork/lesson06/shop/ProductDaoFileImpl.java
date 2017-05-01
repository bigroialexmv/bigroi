package com.bigroi.classwork.lesson06.shop;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class ProductDaoFileImpl implements Closeable {
	
	private RandomAccessFile dataFile = null;
	
	public ProductDaoFileImpl() throws DaoException {
		try {
			File dir = new File("D:\\temp\\database");
			dir.mkdirs();
			if ( !dir.exists() ) {
				throw new DaoException("Wrong path to data file " + dir.getAbsolutePath());
			}
			dataFile = new RandomAccessFile("D:\\temp\\database\\products.dbt", "rw");
		} catch (FileNotFoundException e) {
			throw new DaoException("Could not initialize data file", e);
		}
	}

	// code 8 bytes
	// name 100 bytes
	// price 32 bytes
	public void saveProduct(Product product) throws DaoException {
		byte[] buffer = new byte[140];
		
		String code = product.getCode();		
		byte[] codeBuffer = code.getBytes();
		if (codeBuffer.length > 8) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(codeBuffer, 0, buffer, 0, codeBuffer.length);
		
		String name = product.getName();
		byte[] nameBuffer = name.getBytes();
		if (nameBuffer.length > 100) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(nameBuffer, 0, buffer, 8, nameBuffer.length);
		
		BigDecimal price = product.getPrice();
		byte[] priceBuffer = price.toString().getBytes();
		if (nameBuffer.length > 32) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(priceBuffer, 0, buffer, 108, priceBuffer.length);
		
		try {
			dataFile.write(buffer);
		} catch (IOException e) {
			throw new DaoException("Could not write to file", e);
		}
		
	}
	
	public Product getProductByRecordNo(int n) throws DaoException {
		Product product = null;//new Product();
		try {
			dataFile.seek(n * 140);
			
			byte[] codeBuffer = new byte[8];
			dataFile.read(codeBuffer);
			String code = new String(codeBuffer);
			code = code.trim();
			
			byte[] nameBuffer = new byte[100];
			dataFile.read(nameBuffer);
			String name = new String(nameBuffer).trim();
			
			byte[] priceBuffer = new byte[32];
			dataFile.read(priceBuffer);
			String price = new String(priceBuffer);
			
			product = new Product(code, name, Double.parseDouble(price));
		} catch (IOException e) {
			throw new DaoException("Could not read file", e);
		}		
		return product;
	}
	
	public Product getProductByCode(String code) throws DaoException {
		Product product = null;//new Product();
		return product;
	}

	@Override
	public void close() {
		if (dataFile != null) {
			try {
				dataFile.close();
				System.out.println("Product data file is closed");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}
