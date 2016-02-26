package dao.impl;


import entity.User;
import exceptions.DaoException;

public interface UserDAO extends Dao<User> {

	public User getUserByName(String userName, String password) throws DaoException;
}
