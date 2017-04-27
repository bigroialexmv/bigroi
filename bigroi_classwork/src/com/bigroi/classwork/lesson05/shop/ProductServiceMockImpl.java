package com.bigroi.classwork.lesson05.shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductServiceMockImpl implements ProductService  {
	// в поле codeProductMap храним все продукты, получаемые при вводе пользователем либо из файла при запуске приложения
	private Map<String, Product> codeProductMap = new HashMap<String, Product>();

	/**
	 * Находит объект Product по его коду в мапе
	 */
	@Override
	public Product findProductByCode(String code) throws Exception {
		return codeProductMap.get( code );
	}

	/**
	 * Добавляет в мапу объект Product, в качестве ключа берется код продукта
	 */
	@Override
	public void saveProduct(Product product) throws Exception {
		String code = product.getCode();
		codeProductMap.put( code, product );
	}
	
	/**
	 * Возвращает все продукты, хранимые в мапе в новом объекте   
	 */
	public Collection<Product> findAllProducts() throws Exception {
		Collection<Product> products = codeProductMap.values();
		return products;
	}

	
}
