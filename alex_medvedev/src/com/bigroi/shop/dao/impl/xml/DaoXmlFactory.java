/**
 * 
 */
package com.bigroi.shop.dao.impl.xml;

import com.bigroi.shop.dao.PurchaseOrderDao;
import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.dao.factory.DaoFactory;
import com.bigroi.shop.dao.impl.jdbc.UserAddressDaoImplJdbc;

/**
 * @author Alexander Medvedev
 *
 */
public class DaoXmlFactory implements DaoFactory {

	@Override
	public UserDao createUserDao() {
		return new UserDaoImplXml();
	}

	@Override
	public PurchaseOrderDao createPurchaseOrderDao() {		
		return new PurchaseOrderDaoImplXml();
	}

	@Override
	public UserAddressDao createUserAddressDao() {
		return new UserAddressDaoImplJdbc();
	}

}
