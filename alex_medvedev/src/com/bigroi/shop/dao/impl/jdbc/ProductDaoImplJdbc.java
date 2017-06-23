/**
 * 
 */
package com.bigroi.shop.dao.impl.jdbc;

import java.util.List;

import com.bigroi.shop.dao.ProductDao;
import com.bigroi.shop.dao.impl.jdbc.core.BaseJdbcDao;
import com.bigroi.shop.model.Product;

/**
 * @author Alexander Medvedev
 *
 */
public class ProductDaoImplJdbc extends BaseJdbcDao implements ProductDao {

	@Override
	public Product findById(int productId) throws Exception {
		return null;
	}

	@Override
	public List<Product> findAll() throws Exception {
		return null;
	}

	@Override
	public int countAll() throws Exception {
		return 0;
	}

}
