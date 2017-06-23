/**
 * 
 */
package com.bigroi.shop.dao.impl.jdbc.core;

import java.sql.Connection;

/**
 * @author Alexander Medvedev
 *
 */
public abstract class BaseJdbcDao {
	
	private ConnectionManager connectionManager;
	
	protected ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	protected Connection getConnection() {
		return getConnectionManager().getConnection();
	}
	
}
