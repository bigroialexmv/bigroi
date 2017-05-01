package lesson06.shop;

public class ShopApp {

	public static void main(String[] args) {
		try (ProductDaoFileImpl productDao = new ProductDaoFileImpl()) {
		
			productDao.saveProduct(new Product("001", "Nokia", 300));
			productDao.saveProduct(new Product("002","iPhone", 700));
			productDao.saveProduct(new Product("003","HTC", 100));
			
			Product product = productDao.getProductByRecordNo(1);
			System.out.println(product);
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

}
