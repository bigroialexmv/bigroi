package com.bigroi.shop.dao.impl.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bigroi.shop.dao.impl.UserDaoImpl;
import com.bigroi.shop.model.User;

public class UserDaoImplTest {
	
	private UserDaoImpl userDao;
	
	@BeforeClass
	public static void beforeTests() {
		//System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void afterTests() {
		//System.out.println("AfterClass");
	}
	
	@Before
	public void beforeTest() {
		//System.out.println("Before");
		System.out.println("------------------------");
		userDao = new UserDaoImpl();
	}
	
	@After
	public void afterTest() {
		//System.out.println("After");
	}
	
	@Test
	public void testFindById() {
		System.out.println("testFindById");
	}
	
	@Test
	public void testFindAll() {
		System.out.println("testFindAll");
		try {
			int count = userDao.count();
			List<User> users = userDao.findAll();
			for(User user : users) {
				System.out.println(user);
			}
			Assert.assertEquals("Invalid user count / findAll", count, users.size());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testCount() {
		try {
			int count = userDao.count();
			System.out.println("testCount: " + count);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}

}
