/**
 * 
 */
package com.bigroi.shop.service.impl.context;

import java.util.AbstractMap;

/**
 * @author Alexander Medvedev
 *
 */
public class ServiceContext {
	
	private AbstractMap<String, Object> nameServiceMap;
	
	protected ServiceContext(AbstractMap<String, Object> nameServiceMap) {
		this.nameServiceMap = nameServiceMap;
	}
	
	public Object getService(String name) {
		return nameServiceMap.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getService(String name, Class<T> C) {
		return (T) nameServiceMap.get(name);
	}
	

}
