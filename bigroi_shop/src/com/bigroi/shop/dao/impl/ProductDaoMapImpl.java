/**
 * 
 */
package com.bigroi.shop.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bigroi.shop.dao.ProductDao;
import com.bigroi.shop.model.Product;

/**
 * @author Alexander Medvedev
 *
 */
public class ProductDaoMapImpl implements ProductDao {

private Map<String, Product> codeProductMap = new HashMap<String, Product>();
	
	private static ProductDao instance; 
	
	private ProductDaoMapImpl() {	
	}
	
	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDaoMapImpl();
		}
		return instance;
	}

	@Override
	public Product findProductByCode(String code) throws Exception {
		return codeProductMap.get( code );
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		String code = product.getCode();
		codeProductMap.put( code, product );
	}
	
	public Collection<Product> findAllProducts() throws Exception {
		Collection<Product> products = codeProductMap.values();
		return products;
	}

}
