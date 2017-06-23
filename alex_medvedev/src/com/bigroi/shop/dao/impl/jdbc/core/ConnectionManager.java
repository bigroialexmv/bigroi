/**
 * 
 */
package com.bigroi.shop.dao.impl.jdbc.core;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Alexander Medvedev
 *
 */
public interface ConnectionManager {

	void ackwire() throws SQLException;

	Connection getConnection();

	void release() throws SQLException;

}