package com.bigroi.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;

/*
Host: sql11.freesqldatabase.com
Database name: sql11179471
Database user: sql11179471
Database password: XRvjw6EMj1
Port number: 3306
 */

public class MySqlTest {

	public static void main(String[] args) throws Exception {
		Connection conn =
			       DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11179471?" +
			                                   "user=sql11179471&password=XRvjw6EMj1");
		

	}

}
