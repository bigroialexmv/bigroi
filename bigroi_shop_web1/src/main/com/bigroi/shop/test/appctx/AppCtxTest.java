package com.bigroi.shop.test.appctx;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.model.User;

public class AppCtxTest {

	public static void main(String[] args) throws Exception {
				
		ClassPathXmlApplicationContext appCtx = 
				new ClassPathXmlApplicationContext("app-context.xml");
		
		User user = new User("First", "Last", "email@bigroi.by", "+3752947777");
		
		UserDao userDao = (UserDao) appCtx.getBean("userDao");
		userDao.save(user);		
		
	}

	void test() {
		DataSource dataSource = new BasicDataSource();
		//....
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}
}
