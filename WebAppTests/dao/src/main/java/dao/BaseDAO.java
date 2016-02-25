package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import exceptions.DaoException;
import dao.impl.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import connect.HibernateUtil;

@Repository
public class BaseDAO<T> implements Dao<T> {
	private static Logger log = Logger.getLogger(BaseDAO.class);


	private SessionFactory sessionFactory;

	public BaseDAO() {

	}
	 @Autowired
	public BaseDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}

	public Serializable save(T t) throws DaoException {
		Serializable id;
		try {
			Session session = currentSession();
			id = session.save(t);
		} catch (HibernateException e) {
			log.error("Error save PERSON in Dao" + e);
			throw new DaoException(e);
		}
		return id;
	}

	public void saveOrUpdate(T t) throws DaoException {
		try {
			Session session = currentSession();
			session.saveOrUpdate(t);
		} catch (HibernateException e) {
			log.error("Error save or update " + t + " in Dao" + e);
			throw new DaoException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) throws DaoException {
		log.info("Get class by id:" + id);
		T t = null;
		try {
			Session session = currentSession();
			t = (T) session.get(getPersistentClass(), id);
		} catch (HibernateException e) {

			log.error("Error get " + getPersistentClass() + " in Dao" + e);
			throw new DaoException(e);
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public T load(Serializable id) throws DaoException {
		log.info("Load class by id:" + id);
		T t = null;
		try {
			Session session = currentSession();
			t = (T) session.load(getPersistentClass(), id);
		} catch (HibernateException e) {
			log.error("Error load() " + getPersistentClass() + " in Dao" + e);
			throw new DaoException(e);
		}
		return t;
	}

	public void delete(T t) throws DaoException {
		try {
			Session session = currentSession();
			session.delete(t);
			log.info("Delete:" + t);
		} catch (HibernateException e) {
			log.error("Error save or update PERSON in Dao" + e);
			throw new DaoException(e);
		}
	}

	private Class<T> getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
