package com.morozov.shop.web;

import java.math.BigDecimal;

public class Product {
	
	private String code;
	
	private String name;
	
	private BigDecimal price;

	/**
	 * Creates new product
	 * @param code product code
	 * @param name product name
	 * @param price product price
	 */
	public Product(String code, String name, BigDecimal price) {
		super();
		if ( code == null ) {
			throw new IllegalArgumentException("code must not be null");
		}
		if ( name == null ) {
			throw new IllegalArgumentException("name must not be null");
		}
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public Product(String code, String name, double price) {	
		this(code, name, new BigDecimal(price) );
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		String s = String.format("Product {name=%s, code=%s, price=%s}", name, code, price);
		return s;
	}
	
}
