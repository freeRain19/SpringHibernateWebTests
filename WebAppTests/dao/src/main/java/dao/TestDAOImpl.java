package dao;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import connect.HibernateUtil;
import dao.impl.TestDAO;
import entity.*;
import exceptions.DaoException;

@Repository
public class TestDAOImpl extends BaseDAO<Test> implements TestDAO{

	private static final Logger logger = Logger.getLogger(TestDAOImpl.class);

	public TestDAOImpl() {
	}

	@Autowired
	public TestDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public List<Test> getAllTestNames() throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		List<Test> testsNames = new LinkedList<Test>();
		try {
			String sql = "from Test";
			Query query = session.createQuery(sql);
			testsNames = query.list();
		} catch (HibernateException e) {
			logger.error("getAllTestNames in test ERROR \n" + e);
			throw new DaoException(e);
		}
		return testsNames;
	}


}
