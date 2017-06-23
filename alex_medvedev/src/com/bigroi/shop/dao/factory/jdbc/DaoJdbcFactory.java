/**
 * 
 */
package com.bigroi.shop.dao.factory.jdbc;

import com.bigroi.shop.dao.PurchaseOrderDao;
import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.dao.factory.DaoFactory;
import com.bigroi.shop.dao.impl.jdbc.PurchaseOrderDaoImplJdbc;
import com.bigroi.shop.dao.impl.jdbc.UserAddressDaoImplJdbc;
import com.bigroi.shop.dao.impl.jdbc.UserDaoImplJdbc;
import com.bigroi.shop.dao.impl.jdbc.core.ConnectionManager;

/**
 * @author Alexander Medvedev
 *
 */
public class DaoJdbcFactory implements DaoFactory {
	
	private ConnectionManager connectionManager;
	
	public DaoJdbcFactory(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public UserDao createUserDao() {
		UserDaoImplJdbc userDao = new UserDaoImplJdbc();
		userDao.setConnectionManager(connectionManager);
		return userDao;
	}

	@Override
	public UserAddressDao createUserAddressDao() {		
		UserAddressDaoImplJdbc userDao = new UserAddressDaoImplJdbc();
		userDao.setConnectionManager(connectionManager);
		return userDao;
	}
	
	@Override
	public PurchaseOrderDao createPurchaseOrderDao() {
		PurchaseOrderDaoImplJdbc poDao = new PurchaseOrderDaoImplJdbc();
		poDao.setConnectionManager(connectionManager);
		return poDao;
	}

	
}
