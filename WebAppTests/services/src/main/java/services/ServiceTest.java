package services;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;

import connect.HibernateUtil;
import dao.QuestionDAOImpl;
import dao.TestDAOImpl;
import entity.*;
import exceptions.DaoException;

public class ServiceTest {
	static TestDAOImpl testDAO = TestDAOImpl.getInstance();
	static QuestionDAOImpl questDAO = QuestionDAOImpl.getInstance();
	private Transaction transaction = null;
	private static ServiceTest instance;
	private static final Logger logger = Logger.getLogger(ServiceTest.class);

	private ServiceTest() {

	}

	

	public static synchronized ServiceTest getInstance() {
		if (instance == null) {
			instance = new ServiceTest();
		}
		return instance;
	}

	public List<Test> getAllTests() {
		Session session = HibernateUtil.getInstance().getSession();
		List<Test> testsNames = new LinkedList<Test>();
		try {
			transaction = session.beginTransaction();
			testsNames = testDAO.getAllTestNames();
			transaction.commit();
		} catch (DaoException e) {
			logger.error("transaction getAllTestNames ERROR \b" + e);
			transaction.rollback();
		}
		return testsNames;
	}

	public Serializable addTest(Test test) {
		Session session = HibernateUtil.getInstance().getSession();
		Serializable id = 0;
		try {
			transaction = session.beginTransaction();
			id = testDAO.save(test);
			transaction.commit();
		} catch (DaoException e) {
			logger.error("transaction addTest ERROR \n" + e);
			transaction.rollback();
			id = -1;
		}
		return id;
	}

	public Test getTest(int idTest) {
		Session session = HibernateUtil.getInstance().getSession();
		Test test=null;
		try {
			transaction = session.beginTransaction();
			test = testDAO.get(idTest);
			transaction.commit();
		} catch (DaoException e) {
			logger.error("transaction getTest ERROR \n" + e);
			transaction.rollback();
		}
		return test;
	}
}