package com.bigroi.classwork.lesson06.shop;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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

	public void saveProduct(Product product) throws DaoException {
		
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
