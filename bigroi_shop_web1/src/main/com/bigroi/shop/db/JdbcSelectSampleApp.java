package com.bigroi.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bigroi.shop.model.Product;

/*
Host: sql11.freesqldatabase.com
Database name: sql11179471
Database user: sql11179471
Database password: XRvjw6EMj1
Port number: 3306
 */

public class JdbcSelectSampleApp {
	

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;	
		try {
			conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11179471?" +
			                                   "user=sql11179471&password=XRvjw6EMj1");
			stmt = conn.createStatement();
			String sql = "SELECT CODE, NAME, PRICE FROM PRODUCT ORDER BY NAME DESC, CODE ASC";
			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next() ) {
				int code = rs.getInt("CODE");
				String name = rs.getString("NAME");
				double price = rs.getDouble("PRICE");
				Product p = new Product(new Integer(code).toString(), name, price, null);
				System.out.println(p);
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		

	}

}
