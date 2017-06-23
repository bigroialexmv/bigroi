/**
 * 
 */
package com.bigroi.shop.dao.impl.jdbc.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author Alexander Medvedev
 *
 */
public class DataSourceFactory {
	
	private Properties properties;
	
	public DataSourceFactory(Properties properties) {
		this.properties = properties;
	}
	
	public DataSourceFactory(String propertiesFile) throws IOException {
		this.properties = new Properties();
		try( InputStream propsIn = DataSourceFactory.class.getResourceAsStream(propertiesFile) ) {
			if (propsIn != null) {
				properties.load(propsIn);
				return;
			}			
		}
		try( InputStream propsIn = new FileInputStream(propertiesFile) ) {
			properties.load(propsIn);
		}
	}
	
	public DataSource createDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl( properties.getProperty("url") );
		ds.setUsername( properties.getProperty("username"));
		ds.setPassword( properties.getProperty("password"));
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);		
		return ds;
	}
	

}
