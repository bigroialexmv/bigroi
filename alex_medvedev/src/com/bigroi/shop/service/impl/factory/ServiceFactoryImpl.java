/**
 * 
 */
package com.bigroi.shop.service.impl.factory;

import com.bigroi.shop.dao.factory.DaoFactory;
import com.bigroi.shop.dao.impl.jdbc.core.ConnectionManager;
import com.bigroi.shop.service.PurchaseOrderService;
import com.bigroi.shop.service.UserService;
import com.bigroi.shop.service.factory.ServiceFactory;
import com.bigroi.shop.service.impl.PurchaseOrderServiceImpl;
import com.bigroi.shop.service.impl.UserServiceImpl;

/**
 * @author Alexander Medvedev
 *
 */
public class ServiceFactoryImpl implements ServiceFactory {
	
	private DaoFactory daoFactory;
	
	private ConnectionManager connectionManager;
	
	public ServiceFactoryImpl(DaoFactory daoFactory, ConnectionManager connectionManager) {
		this.daoFactory = daoFactory;
		this.connectionManager = connectionManager;
	}
	
	@Override
	public UserService createUserService() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setConnectionManager(connectionManager);
		userService.setUserDao( daoFactory.createUserDao() );
		userService.setUserAddressDao( daoFactory.createUserAddressDao() );
		return userService;
	}

	@Override
	public PurchaseOrderService createPurchaseOrderService() {
		PurchaseOrderServiceImpl poService = new PurchaseOrderServiceImpl();
		poService.setConnectionManager(connectionManager);
		poService.setPurchaseOrderDao( daoFactory.createPurchaseOrderDao() );
		return poService;
	}

}
