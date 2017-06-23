/**
 * 
 */
package com.bigroi.shop.service.impl.context;

import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexander Medvedev
 *
 */
public class ServiceContextBuilder {
	
	private AbstractMap<String, Object> nameServiceMap;

	public ServiceContextBuilder() {
		nameServiceMap = new ConcurrentHashMap<String, Object>();
	}
	
	public ServiceContextBuilder set(String id, Object service) {
		if ( nameServiceMap.containsKey(id) ) {
			throw new RuntimeException(String.format("Service with id %s already regitered", id));
		}		
		nameServiceMap.put(id, service);
		return this;
	}
	
	public ServiceContext build() {
		return new ServiceContext(nameServiceMap);
	}
}
