package com.bigroi.classwork.lesson06.shop;

public class ShopApp {

	public static void main(String[] args) {
		try (ProductDaoFileImpl productDao = new ProductDaoFileImpl()) {
			
		} catch (DaoException e) {			
			e.printStackTrace();
		}

	}

}
