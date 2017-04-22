package com.bigroi.classwork.lesson05.shop;

import java.math.BigDecimal;

public class Product {
	
	private String name;
	
	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		super();
		if ( name == null ) {
			throw new IllegalArgumentException("name must not be null");
		}
		
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, double price) {
		
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}	
	
}
