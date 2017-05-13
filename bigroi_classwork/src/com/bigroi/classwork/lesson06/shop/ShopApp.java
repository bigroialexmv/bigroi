package com.bigroi.classwork.lesson06.shop;

public class ShopApp {

	public static void main(String[] args) {
		try ( ProductDaoFileImpl productDao = new ProductDaoFileImpl() ) {
			Product product = new Product("001", "Nokia", 300);
			productDao.insertProduct( product );			
			productDao.insertProduct( new Product("002", "iPhone", 200) );
			productDao.insertProduct( new Product("003", "HTC", 100) );
			
			product = productDao.getProductByRecordNo(2);
			System.out.println(product);
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

}
