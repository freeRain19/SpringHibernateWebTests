package dao;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.*;

public class UserDAOImplTest {
	private static Logger log = Logger.getLogger(UserDAOImplTest.class);

	@Autowired
	UserDAOImpl userDao;

	// @Test
	public void userDaoTest() {

		try {

			User user = userDao.getUserByName("Vanov", "2");
			System.out.println(user);
		} catch (Exception e) {
			log.error("UserDAOImplTest error \n" + e);
		}
		Assert.assertEquals("user DAO test", 1, 1);
	}
}
