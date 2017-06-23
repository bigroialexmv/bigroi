/**
 * 
 */
package com.bigroi.shop.service.impl;

import com.bigroi.shop.dao.PurchaseOrderDao;
import com.bigroi.shop.model.PurchaseOrder;
import com.bigroi.shop.service.PurchaseOrderService;

/**
 * @author Alexander Medvedev
 *
 */
public class PurchaseOrderServiceImpl extends BaseService implements PurchaseOrderService {
	
	private PurchaseOrderDao purchaseOrderDao;
	
	protected PurchaseOrderDao getPurchaseOrderDao() {
		return purchaseOrderDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	public void save(PurchaseOrder po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PurchaseOrder findById(int poId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
