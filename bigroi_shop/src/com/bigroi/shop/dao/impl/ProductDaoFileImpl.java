/**
 * 
 */
package com.bigroi.shop.dao.impl;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;

import com.bigroi.shop.dao.ProductDao;
import com.bigroi.shop.model.Product;

/**
 * @author Alexander Medvedev
 *
 */
public class ProductDaoFileImpl implements ProductDao  {
	
	private RandomAccessFile productFile;
	
	public ProductDaoFileImpl(String fileName) throws Exception {
		productFile = new RandomAccessFile(fileName, "rw");
	}
	
	@Override
	public Product findProductByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		byte[] recordBuffer = new byte[140];
		System.arraycopy(product.getCode().getBytes(), 0, recordBuffer, 0, 4);
		byte[] nameBuffer = product.getName().getBytes();
		System.arraycopy(nameBuffer, 0, recordBuffer, 4, nameBuffer.length);
		byte[] priceBuffer = product.getPrice().toString().getBytes();
		System.arraycopy(priceBuffer, 0, recordBuffer, 104, priceBuffer.length);
		productFile.write(recordBuffer);
	}

	@Override
	public Collection<Product> findAllProducts() throws Exception {
		Collection<Product> products = new ArrayList<Product>();
		byte[] buffer = new byte[140];
		productFile.seek(0);
		while ( productFile.read(buffer) > 0 ) {
			String code = new String(buffer, 0, 4);
			String name = new String(buffer, 4, 100);
			String price = new String(buffer, 100, 36);
			Product product = new Product(code, name, Double.parseDouble(price) );
			products.add( product );
		}		
		return products;
	}

}
