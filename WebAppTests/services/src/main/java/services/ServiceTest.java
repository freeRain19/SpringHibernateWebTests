package services;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.impl.TestDAO;
import entity.*;
import exceptions.DaoException;

import impl.IServiceTest;

@Service
@Transactional
public class ServiceTest implements IServiceTest {
	@Autowired
	TestDAO testDAO;

	private static final Logger logger = Logger.getLogger(ServiceTest.class);

	public ServiceTest() {
	}

	@Transactional(readOnly = true)
	public List<Test> getAllTests() {

		List<Test> testsNames = new LinkedList<Test>();
		try {
			testsNames = testDAO.getAllTestNames();
		} catch (DaoException e) {
			logger.error("getAllTestNames ERROR \b" + e);
		}
		return testsNames;
	}

	@Transactional
	public Serializable addTest(Test test) {
		Serializable id = 0;
		try {
			id = testDAO.save(test);
		} catch (DaoException e) {
			logger.error("addTest ERROR \n" + e);
			id = -1;
		}
		return id;
	}

	@Transactional(readOnly = true)
	public Test getTest(int idTest) {
		Test test = null;
		try {
			test = testDAO.get(idTest);
		} catch (DaoException e) {
			logger.error(" getTest ERROR \n" + e);
		}
		return test;
	}
}