package com.bigroi.shop.service.impl;

import java.util.Collection;

import com.bigroi.shop.dao.ProductDao;
import com.bigroi.shop.model.Product;
import com.bigroi.shop.service.ProductService;

public class ProductServiceImpl implements ProductService  {
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {		
	}
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product findProductByCode(String code) throws Exception {
		return productDao.findProductByCode(code);
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		productDao.saveProduct(product);
	}
	
	@Override
	public Collection<Product> findAllProducts() throws Exception {
		return productDao.findAllProducts();
	}

	
}
