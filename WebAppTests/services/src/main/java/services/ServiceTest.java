package services;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.impl.TestDAO;
import entity.*;
import exceptions.DaoException;

import impl.IServiceTest;

@Service
public class ServiceTest implements IServiceTest {
	@Autowired
	TestDAO testDAO;

	private static final Logger logger = Logger.getLogger(ServiceTest.class);

	public ServiceTest() {
	}

	public List<Test> getAllTests() {

		List<Test> testsNames = new LinkedList<Test>();
		try {
			testsNames = testDAO.getAllTestNames();
		} catch (DaoException e) {
			logger.error("transaction getAllTestNames ERROR \b" + e);
		}
		return testsNames;
	}

	public Serializable addTest(Test test) {
		Serializable id = 0;
		try {
			id = testDAO.save(test);
		} catch (DaoException e) {
			logger.error("transaction addTest ERROR \n" + e);
			id = -1;
		}
		return id;
	}

	public Test getTest(int idTest) {
		Test test = null;
		try {
			test = testDAO.get(idTest);
		} catch (DaoException e) {
			logger.error("transaction getTest ERROR \n" + e);
		}
		return test;
	}
}