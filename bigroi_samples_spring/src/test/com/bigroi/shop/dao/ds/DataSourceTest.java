/**
 * 
 */
package com.bigroi.shop.dao.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Alexander Medvedev
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/application-context.xml")
public class DataSourceTest {	
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Test
	public void test() {
		try (Connection con = dataSource.getConnection()) {
			System.out.println("Connection obtained successfully");
		} catch(SQLException e) {
			Assert.fail( e.getMessage() );
		}
	}

}
