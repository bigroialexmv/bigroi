/**
 * 
 */
package com.bigroi.shop.service.impl;

import com.bigroi.shop.dao.impl.jdbc.core.ConnectionManager;

/**
 * @author Alexander Medvedev
 *
 */
public class BaseService {
	
	private ConnectionManager connectionManager;

	protected ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	
	public void ackwireConnection() throws Exception {
		this.connectionManager.ackwire();
	}
	
	public void ackwireConnection(boolean transactional) throws Exception {
		this.connectionManager.ackwire();
		this.connectionManager.getConnection().setAutoCommit(false);
	}
	
	public void releaseConnection() throws Exception {
		this.connectionManager.getConnection().setAutoCommit(true);
		this.connectionManager.release();
	}
	

}
