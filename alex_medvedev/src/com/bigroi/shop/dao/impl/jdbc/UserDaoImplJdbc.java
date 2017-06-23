package com.bigroi.shop.dao.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.dao.impl.jdbc.core.BaseJdbcDao;
import com.bigroi.shop.model.User;

public class UserDaoImplJdbc extends BaseJdbcDao implements UserDao {
	
	public User findById(int userId) throws Exception {
		Statement stmt = null;	
		try {
			stmt = getConnection().createStatement();
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
			return user;
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
	}
	
	public int countAll() throws Exception {
		Statement stmt = null;	
		try {
			stmt = getConnection().createStatement();
			String sql = "SELECT COUNT(*) FROM USER";
			ResultSet rs = stmt.executeQuery(sql);
			int count = -1;
			if (rs.next()) {
				count = rs.getInt(1);				
			} else {
				throw new Exception("no count returned from user table");
			}
			rs.close();
			return count;
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}		
	}

	public List<User> findAll() throws Exception {
		Statement stmt = null;	
		try {
			stmt = getConnection().createStatement();
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
		}
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
