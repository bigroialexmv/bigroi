package com.bigroi.classwork.lesson05.shop;

public interface ProductService {
	
	public Product findProductByCode(String code) throws Exception;
	
	public void saveProduct(Product product) throws Exception;
}
