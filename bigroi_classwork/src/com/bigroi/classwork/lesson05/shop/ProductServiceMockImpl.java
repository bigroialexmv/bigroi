package com.bigroi.classwork.lesson05.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceMockImpl implements ProductService  {
	
	private Map<String, Product> codeProductMap = new HashMap<String, Product>();

	@Override
	public Product findProductByCode(String code) throws Exception {
		return codeProductMap.get( code );
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		codeProductMap.put( product.getCode(), product );	
	}

	
}
