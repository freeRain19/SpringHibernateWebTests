package dao;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import entity.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import exceptions.DaoException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.impl.TestDAO;
@ContextConfiguration("/beans-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDAOImplTest {
	private static Logger log = Logger.getLogger(TestDAOImplTest.class);
	@Autowired
	TestDAO testDao;

	 @Test
	public void testDaoTest() {
		Serializable id;
		entity.Test test1 = null;
		entity.Test test2 = null;
		List<Question> questions = new LinkedList<Question>();
		List<Answer> answers;
		Question question1 = null;
		answers = new LinkedList<>();

		question1 = new Question("test 1Question new ");
		question1.setTest(test1);
		Question question2 = new Question("test 2Question new ");
		question2.setTest(test1);
		answers.add(new Answer("create answer1", (byte) 1, question1));
		answers.add(new Answer("create answer22", (byte) 0, question1));
		answers.add(new Answer("create answer33", (byte) 0, question1));
		try {
			test1 = new entity.Test("English","newName");
			id = testDao.save(test1);
			test2 = (entity.Test) testDao.get(id);
		} catch (DaoException e) {
			log.error("TestDAOImplTest exception /n" + e);
		}
		Assert.assertEquals("TEST test=test1", test1, test1);
	}

	@Test
	public void getAllnames() {
		List<entity.Test> tests = new LinkedList<entity.Test>();
		List<entity.Test> tests2 = new LinkedList<entity.Test>();
		entity.Test test = null;
		try {
			tests = testDao.getAllTestNames();
			test = new entity.Test("English", "Junit");
			testDao.save(test);
			tests2=testDao.getAllTestNames();

		} catch (DaoException e) {
			log.error("Error in JUnit test\n" + e);
		}

		Assert.assertNotSame("Tests pool is same ",tests2, tests);
	}
}
