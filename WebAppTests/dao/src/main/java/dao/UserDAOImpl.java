package dao;

import org.apache.log4j.Logger;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import connect.HibernateUtil;
import entity.User;
import exceptions.DaoException;

@Repository
public class UserDAOImpl extends BaseDAO<User> {
	private static UserDAOImpl userDao;
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	private UserDAOImpl() {
	}

	Session currentSession() {
		return sessionFactory.openSession();
	}

	public static synchronized UserDAOImpl getInstance() {
		if (userDao == null) {
			userDao = new UserDAOImpl();
		}
		return userDao;
	}

	public User getUserByName(String name, String password) throws DaoException {
		User user;
		try {
			// Session session = HibernateUtil.getInstance().getSession();
			Session session = currentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("name", name));
			criteria.add(Restrictions.and((Restrictions.eq("password", password))));
			user = (User) criteria.uniqueResult();
		} catch (HibernateException hib) {
			hib.printStackTrace();
			logger.error("get UserByName exeption \n" + hib);
			throw new DaoException(hib);
		} catch (Exception e) {
			logger.error("get UserByName exeption \n" + e);
			e.printStackTrace();
			throw new DaoException(e);
		}
		return user;
	}

}
