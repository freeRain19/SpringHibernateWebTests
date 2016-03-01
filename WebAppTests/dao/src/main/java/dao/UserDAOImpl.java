package dao;

import org.apache.log4j.Logger;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dao.impl.UserDAO;
import entity.User;
import exceptions.DaoException;

@Repository
public class UserDAOImpl extends BaseDAO<User> implements UserDAO{

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	public UserDAOImpl() {
	}

	
	public User getUserByName(String name) throws DaoException {
		User user;
		try {
			Session session = currentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("name", name));
		//	criteria.add(Restrictions.and((Restrictions.eq("password", password))));
			user = (User) criteria.uniqueResult();
		} catch (HibernateException hib) {
			hib.printStackTrace();
			logger.error("get UserByName exeption \n" + hib);
			throw new DaoException(hib);
		} catch (Exception e) {
			logger.error("get UserByName exeption \n" + e);
			throw new DaoException(e);
		}
		return user;
	}

}
