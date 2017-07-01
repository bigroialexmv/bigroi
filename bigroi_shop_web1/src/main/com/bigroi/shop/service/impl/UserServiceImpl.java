package com.bigroi.shop.service.impl;

import java.util.List;

import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.model.User;
import com.bigroi.shop.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	private UserAddressDao userAddressDao;

	@Override
	public User findUserById(int userId) throws Exception {		
		return userDao.findById(userId);
	}

	@Override
	public void save(User user) throws Exception {
		userDao.save(user);
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
