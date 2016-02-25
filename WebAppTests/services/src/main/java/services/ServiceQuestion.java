package services;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import connect.HibernateUtil;
import dao.QuestionDAOImpl;
import entity.*;
import exceptions.DaoException;

public class ServiceQuestion {
	static QuestionDAOImpl questDAO = QuestionDAOImpl.getInstance();
	private Transaction transaction = null;
	private static ServiceQuestion instance;
	private static final Logger logger = Logger.getLogger(ServiceQuestion.class);

	private ServiceQuestion() {

	}

	public static synchronized ServiceQuestion getInstance() {
		if (instance == null) {
			instance = new ServiceQuestion();
		}
		return instance;
	}

	/**
	 * 
	 * @param page
	 *            page which we take from database
	 * @param test
	 *            current Test which we do
	 * @return compile DTO (List questions, page, remainPage )
	 */
	public QuestionDTO getQuestionByTest(int page, Test test) {
		Session session = HibernateUtil.getInstance().getSession();
		QuestionDTO qDTO = null;
		List<Question> questions = new LinkedList<Question>();
		int maxQuestions = 1;
		try {
			transaction = session.beginTransaction();
			questions = questDAO.getQuestionPage(page, test, maxQuestions);
			if (questions.size() <= 0)
				return null;
			int countPages = (int) (questDAO.getCountQuestionsByTestId(test.getIdTest()) / maxQuestions);
			qDTO = new QuestionDTO(questions, page, countPages - page);
			transaction.commit();

		} catch (DaoException e) {
			logger.error("transaction getQuestionByTest ERROR \n" + e);
			transaction.rollback();
		}
		return qDTO;
	}

	/**
	 * 
	 * @param question
	 *            Question what we add in database
	 * @return Serializable number of id in db
	 */
	public Serializable addQuestion(Question question) {
		Session session = HibernateUtil.getInstance().getSession();
		Serializable id=0;
		try {
			transaction = session.beginTransaction();
			id=questDAO.save(question);
			transaction.commit();
		} catch (DaoException e) {
			logger.error("transaction getQuestionByTest ERROR \n" + e);
			transaction.rollback();
		}
		return id;
	}

}
