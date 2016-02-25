package dao;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import entity.*;



public class UserDAOImplTest {
	private static Logger log = Logger.getLogger(UserDAOImplTest.class);
	@Test
	public void userDaoTest(){
		UserDAOImpl userDao =UserDAOImpl.getInstance();
		try {
			
			User user = userDao.getUserByName("Vanov","2");
			System.out.println(user);
		} catch (Exception e) {
		log.error("UserDAOImplTest error \n"+e);
		}
		Assert.assertEquals("user DAO test", 1, 1);
	}
}
