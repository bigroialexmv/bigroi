/**
 * 
 */
package com.bigroi.shop.dao;

import java.util.List;

import com.bigroi.shop.model.UserAddress;

/**
 * @author Alexander Medvedev
 *
 */
public interface UserAddressDao {
	
	public void save(List<UserAddress> adresses) throws Exception;

}
