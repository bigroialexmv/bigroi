/**
 * 
 */
package com.bigroi.shop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Alexander Medvedev
 *
 */
public class DataSource {

	/**
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11179471?" +
                "user=sql11179471&password=XRvjw6EMj1");
		return conn;
	}

	
}
