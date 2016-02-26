package services;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.impl.QuestionDAO;
import entity.*;
import exceptions.DaoException;
import impl.IServiceQuestion;

@Service
public class ServiceQuestion implements IServiceQuestion{

	@Autowired
	QuestionDAO questDAO;

	private static final Logger logger = Logger.getLogger(ServiceQuestion.class);

	public ServiceQuestion() {

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
		QuestionDTO qDTO = null;
		List<Question> questions = new LinkedList<Question>();
		int maxQuestions = 1;
		try {
			questions = questDAO.getQuestionPage(page, test, maxQuestions);
			if (questions.size() <= 0)
				return null;
			int countPages = (int) (questDAO.getCountQuestionsByTestId(test.getIdTest()) / maxQuestions);
			qDTO = new QuestionDTO(questions, page, countPages - page);

		} catch (DaoException e) {
			logger.error("transaction getQuestionByTest ERROR \n" + e);
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
		Serializable id = 0;
		try {
			id = questDAO.save(question);
		} catch (DaoException e) {
			logger.error("transaction getQuestionByTest ERROR \n" + e);
		}
		return id;
	}

}
