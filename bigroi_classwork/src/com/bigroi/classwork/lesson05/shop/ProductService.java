package com.bigroi.classwork.lesson05.shop;

import java.util.Collection;

public interface ProductService {
	
	public Product findProductByCode(String code) throws Exception;
	
	public void saveProduct(Product product) throws Exception;
	
	public Collection<Product> findAllProducts() throws Exception;
	
	
}
