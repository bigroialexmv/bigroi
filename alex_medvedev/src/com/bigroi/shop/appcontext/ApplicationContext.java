/**
 * 
 */
package com.bigroi.shop.appcontext;

import java.io.IOException;

import com.bigroi.shop.dao.factory.DaoFactory;
import com.bigroi.shop.dao.factory.jdbc.DaoJdbcFactory;
import com.bigroi.shop.dao.impl.jdbc.core.ConnectionManager;
import com.bigroi.shop.dao.impl.jdbc.core.ConnectionManagerImpl;
import com.bigroi.shop.service.factory.ServiceFactory;
import com.bigroi.shop.service.impl.context.ServiceContext;
import com.bigroi.shop.service.impl.context.ServiceContextBuilder;
import com.bigroi.shop.service.impl.factory.ServiceFactoryImpl;

/**
 * @author Alexander Medvedev
 *
 */
public class ApplicationContext {

	private static volatile ApplicationContext instance;
	
	private ServiceContext serviceContext;
	
	private ApplicationContext() throws IOException {		
		ConnectionManager connectionManager = new ConnectionManagerImpl("/datasource.properties");
		DaoFactory daoFactory = new DaoJdbcFactory(connectionManager);
		ServiceFactory serviceFactory = new ServiceFactoryImpl(daoFactory, connectionManager);		
		buildContext(daoFactory, serviceFactory);		
	}
	
	protected void buildContext(DaoFactory daoFactory, ServiceFactory serviceFactory) {
		ServiceContextBuilder scb = new ServiceContextBuilder();
		scb
			.set("userService", serviceFactory.createUserService() )
			.set("poService", serviceFactory.createPurchaseOrderService());		
		this.serviceContext = scb.build();
	}
	
	public static ApplicationContext getInstance() {
		if (instance == null) {
			synchronized (ApplicationContext.class) {
				if (instance == null) {
					try {
						instance = new ApplicationContext();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}
	
	public <T> T getService(String name, Class<T> serviceClass) {
		return serviceContext.getService(name, serviceClass);
	}
}
