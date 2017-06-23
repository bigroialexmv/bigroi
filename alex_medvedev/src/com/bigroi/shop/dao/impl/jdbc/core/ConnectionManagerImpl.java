/**
 * 
 */
package com.bigroi.shop.dao.impl.jdbc.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Alexander Medvedev
 *
 */
public class ConnectionManagerImpl implements ConnectionManager {
	
	private ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
	
	private DataSource dataSource;
	
	public ConnectionManagerImpl(String dataSourcePropsFile) throws IOException {
		DataSourceFactory dataSourceFactory = new DataSourceFactory(dataSourcePropsFile);
		dataSource = dataSourceFactory.createDataSource();
	}
	
	@Override
	public void ackwire() throws SQLException {
		if (connections.get() != null) {
			throw new IllegalStateException("Connection already in use");
		}
		Connection con = dataSource.getConnection();	
		connections.set(con);		
	}
	
	@Override
	public Connection getConnection() {
		Connection con = connections.get();
		if (con == null) {
			throw new IllegalStateException("Connection not ackwired");
		}
		return con;
	}
	
	@Override
	public void release() throws SQLException {
		Connection con = connections.get();
		connections.remove();
		if (con == null) {
			throw new IllegalStateException("Connection not ackwired");
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
