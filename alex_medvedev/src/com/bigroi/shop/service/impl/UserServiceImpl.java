/**
 * 
 */
package com.bigroi.shop.service.impl;

import java.util.List;

import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.model.User;
import com.bigroi.shop.service.UserService;

/**
 * @author Alexander Medvedev
 *
 */
public class UserServiceImpl extends BaseService implements UserService {

	private UserDao userDao;
	
	private UserAddressDao userAddressDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserAddressDao getUserAddressDao() {
		return userAddressDao;
	}

	public void setUserAddressDao(UserAddressDao userAddressDao) {
		this.userAddressDao = userAddressDao;
	}	
	
	@Override
	public void save(User user) throws Exception {
		ackwireConnection(true);
		try {
			getUserDao().save( user );
			getUserAddressDao().save( user.getAdresses() );
		} finally {
			releaseConnection();
		}		
	}

	@Override
	public User findUserById(int userId) throws Exception {
		return null;
	}

	@Override
	public int countAll() throws Exception {
		ackwireConnection();
		try {
			return getUserDao().countAll();
		} finally {
			releaseConnection();
		}
	}

	@Override
	public List<User> findAll() throws Exception {
		ackwireConnection();
		try {
			return getUserDao().findAll();
		} finally {
			releaseConnection();
		}
	}	
	


}
