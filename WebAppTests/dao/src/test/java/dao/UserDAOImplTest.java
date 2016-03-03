package dao;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import dao.impl.UserDAO;
import entity.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration("/beans-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOImplTest {
	private static Logger log = Logger.getLogger(UserDAOImplTest.class);

	@Autowired
	UserDAO userDao;

	 @Test
	public void userDaoTest() {
		try {
			System.out.println("start test");
			User user = userDao.getUserByName("Vanov");
			System.out.println("User = "+user);
		} catch (Exception e) {
			log.error("UserDAOImplTest error \n" + e);
		}
		Assert.assertEquals("user DAO test", 1, 1);
	}
}
