/**
 * 
 */
package com.bigroi.shop.service.factory;

import com.bigroi.shop.service.PurchaseOrderService;
import com.bigroi.shop.service.UserService;

/**
 * @author Alexander Medvedev
 *
 */
public interface ServiceFactory {
	
	public UserService createUserService();
	
	public PurchaseOrderService createPurchaseOrderService();
	
}
