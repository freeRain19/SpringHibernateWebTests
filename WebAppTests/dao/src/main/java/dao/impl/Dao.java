package dao.impl;

import java.io.Serializable;

import exceptions.DaoException;

public interface Dao<T> {

	T get(Serializable id) throws DaoException;

	void saveOrUpdate(T t) throws DaoException;

	Serializable save(T t) throws DaoException;

	T load(Serializable id) throws DaoException;

	void delete(T t) throws DaoException;
}
