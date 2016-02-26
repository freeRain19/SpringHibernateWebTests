package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Question;
import entity.Test;
import exceptions.DaoException;

public interface QuestionDAO extends Dao<Question>{
	public List<Question> getQuestionPage(int page, Test test, int maxQuestions) throws DaoException;

	public int getCountQuestionsByTestId(int idTest) throws DaoException;

	public Serializable save(Question question) throws DaoException;
}
