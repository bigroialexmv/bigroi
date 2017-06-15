package com.bigroi.shop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigroi.shop.dao.impl.DataSource;
import com.bigroi.shop.model.User;

public class UserDaoImpl {
	
	public User findById(int userId) throws Exception {
		Connection conn = null;
		Statement stmt = null;	
		try {
			conn = DataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE, CRTD_TMS, UPDT_TMS FROM USER WHERE USER_ID='" + userId + "'";
			ResultSet rs = stmt.executeQuery(sql);
			User user = new User();			
			if (rs.next()) {
				user.setId(userId);
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPhone(rs.getString("PHONE"));
				user.setCreated(rs.getTimestamp("CREATED"));
				user.setUpdated(rs.getTimestamp("UPDATED"));
			}
			rs.close();
			return user;
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
	
	public int count() throws Exception {
		Connection conn = null;
		Statement stmt = null;	
		try {
			conn = DataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) FROM USER";
			ResultSet rs = stmt.executeQuery(sql);
			int count = -1;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			return count;
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

	public List<User> findAll() throws Exception {
		Connection conn = null;
		Statement stmt = null;	
		try {
			conn = DataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, CRTD_TMS, UPDT_TMS FROM USER";
			ResultSet rs = stmt.executeQuery(sql);
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("USER_ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPhone(rs.getString("PHONE"));
				user.setCreated(rs.getTimestamp("CRTD_TMS"));
				//user.setUpdated(rs.getTimestamp("UPDT_TMS"));
				users.add(user);
			}
			rs.close();
			return users;
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
