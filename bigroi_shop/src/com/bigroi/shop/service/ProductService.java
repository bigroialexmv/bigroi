package com.bigroi.shop.service;

import java.util.Collection;

import com.bigroi.shop.model.Product;

public interface ProductService {
	
	public Product findProductByCode(String code) throws Exception;
	
	public void saveProduct(Product product) throws Exception;
	
	public Collection<Product> findAllProducts() throws Exception;
	
	
}
