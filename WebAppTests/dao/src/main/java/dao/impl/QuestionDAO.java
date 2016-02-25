package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface QuestionDAO {
	public int addQuestion(int idTest, String QuestionText) throws SQLException;

	public ResultSet getQuestionListByIdTest(int idTest) throws SQLException;

	public void updateQuestion(String field, String value, int id) throws SQLException;

	public void deleteQuestion(int id) throws SQLException;
}
