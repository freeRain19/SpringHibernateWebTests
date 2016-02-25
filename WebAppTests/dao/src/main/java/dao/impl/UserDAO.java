package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO {
	public void addUser(int idAccessLevel, String name) throws SQLException;

	public ResultSet selectUser(String listFields, String field, String symbol, String val) throws SQLException;

	public ResultSet selectUserPass(String listFields, String field, String symbol, String val, String pass)
			throws SQLException;

	public void updateUser(String field, String value, int id) throws SQLException;

	public void deleteUser(int id) throws SQLException;
}
