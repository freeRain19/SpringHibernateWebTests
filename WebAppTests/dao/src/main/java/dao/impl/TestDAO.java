package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface TestDAO {
	
	public int addTest(String nameSubject,String testName) throws SQLException;

	public ResultSet selectTestById(int idTest) throws SQLException;
	
	public ResultSet selectAllTests() throws SQLException;
	
	
	public void updateTest(String field, String value, int id);

	
	public void deleteTest(int id) throws SQLException;
}
