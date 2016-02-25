package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Answer;

public interface AnswerDAO {
	
	public void addAnswer(Answer answer,int questionId) throws SQLException;
	public ResultSet selectAnswerByIdQ(int idQuestion) throws SQLException;
	public void updateAnswer(String field, String value, int id) throws SQLException;
	public void deleteAnswer(int id) throws SQLException;

}
