/**
 * 
 */
package com.bigroi.shop.dao.impl.test;

import java.util.Collection;

import org.junit.Test;

import com.bigroi.shop.dao.impl.ProductDaoFileImpl;
import com.bigroi.shop.model.Product;

/**
 * @author Alexander Medvedev
 *
 */
public class ProductDaoFileImplTest {

	@Test
	public void test() throws Exception {
		ProductDaoFileImpl productDao = new ProductDaoFileImpl("D:\\temp\\products.fdb");
		productDao.saveProduct(new Product("0001", "iPhone 5S", 200));
		productDao.saveProduct(new Product("0002", "Nokia", 400));
		Collection<Product> products = productDao.findAllProducts();
		for(Product p : products) {
			System.out.println( p.getCode() );
			System.out.println( p.getName() );
			System.out.println( p.getPrice() );
			System.out.println();
		}
	}

}
