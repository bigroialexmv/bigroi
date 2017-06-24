/**
 * 
 */
package com.bigroi.shop.dao.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bigroi.shop.dao.UserDao;
import com.bigroi.shop.model.User;

/**
 * @author Alexander Medvedev
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/application-context.xml")
@Transactional
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;

	@Test
	@Rollback(true)
	public void testSave() {
		User user = new User("Test first name", "Test last name", "test@email.by", "+375294444444");
		try {
			userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test	
	public void testFindById() {
		try {
			User user = userDao.findById(20);
			assertEquals("inconsistent id", 20, user.getId().intValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindAll() {
		try {
			List<User> users = userDao.findAll();
			for(User user : users) {
				System.out.println(user);
			}
		} catch (Exception e) {			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test	
	public void testCountAll() {
		try {
			int count = userDao.countAll();
			System.out.println("Users count: " + count);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
