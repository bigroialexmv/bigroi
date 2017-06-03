/**
 * 
 */
package com.bigroi.shop.dao;

import java.util.Collection;

import com.bigroi.shop.model.Product;

/**
 * @author Alexander Medvedev
 *
 */
public interface ProductDao {
	
	public Product findProductByCode(String code) throws Exception;
	
	public void saveProduct(Product product) throws Exception;
	
	public Collection<Product> findAllProducts() throws Exception;

}
