package com.bigroi.shop.dao.impl.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bigroi.shop.appcontext.ApplicationContext;
import com.bigroi.shop.model.User;
import com.bigroi.shop.service.UserService;

public class UserServiceTest {
	
	private static UserService userService;
	
	private static ApplicationContext appContext;
	
	@BeforeClass	
	public static void beforeTests() {
		System.out.println("BeforeClass");
		appContext = ApplicationContext.getInstance();
		userService = appContext.getService("userService", UserService.class);
	}
	
	@AfterClass
	public static void afterTests() {
		//System.out.println("AfterClass");
	}
	
	@Before
	public void beforeTest() {
		//System.out.println("Before");
		System.out.println("------------------------");		
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
			int count = userService.countAll();
			List<User> users = userService.findAll();
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
	public void testCountAll() {
		try {
			int count = userService.countAll();
			System.out.println("testCount: " + count);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}

}
