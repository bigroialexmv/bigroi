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

public class JdbcInsertSampleApp {
	

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		Product p = new Product("", "HTC", 200, "super HTC");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11179471?" +
			                                   "user=sql11179471&password=XRvjw6EMj1");
			stmt = conn.createStatement();
			StringBuilder sqlb = new StringBuilder();
			sqlb.append("INSERT INTO PRODUCT(NAME, PRICE, DESCRIPTION) VALUES(");
			sqlb.append("'").append( p.getName() ).append("'");
			sqlb.append(", ");
			sqlb.append( p.getPrice() );
			sqlb.append(", ");
			sqlb.append("'").append( p.getDescription() ).append("'");
			sqlb.append(")");
			
			String sql = sqlb.toString();
			System.out.println(sql);
			
			// берем сгенерированный базой code продукта
			stmt.execute(sql, Statement.RETURN_GENERATED_KEYS );
			ResultSet rs = stmt.getGeneratedKeys();
			System.out.println(rs.getMetaData().getColumnName(1));
			if (rs.next()) {				
				String code = rs.getString("GENERATED_KEY"); //rs.getString(1);
				System.out.println(code);
				p.setCode(code);
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
		
		System.out.println(p);
	}

}
