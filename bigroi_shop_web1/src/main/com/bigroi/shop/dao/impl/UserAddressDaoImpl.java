package com.bigroi.shop.dao.impl;

import java.util.List;

import com.bigroi.shop.dao.UserAddressDao;
import com.bigroi.shop.model.UserAddress;

public class UserAddressDaoImpl implements UserAddressDao {

	@Override
	public void save(List<UserAddress> adresses) throws Exception {
		System.out.println("saving addresses");
	}

}
