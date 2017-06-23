/**
 * 
 */
package com.bigroi.shop.dao.factory;

import com.bigroi.shop.dao.PurchaseOrderDao;
import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.dao.UserDao;

/**
 * @author Alexander Medvedev
 *
 */
public interface DaoFactory {

	public abstract UserDao createUserDao();
	
	public abstract UserAddressDao createUserAddressDao();
	
	public abstract PurchaseOrderDao createPurchaseOrderDao();
}
