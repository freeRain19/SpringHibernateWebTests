package dao;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import connect.HibernateUtil;
import dao.impl.QuestionDAO;
import entity.*;
import exceptions.DaoException;

@Repository
public class QuestionDAOImpl extends BaseDAO<Question> implements QuestionDAO{
	private static final Logger logger = Logger.getLogger(QuestionDAOImpl.class);

	public QuestionDAOImpl() {

	}

	@Autowired
	public QuestionDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public List<Question> getQuestionPage(int page, Test test, int maxQuestions) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		List<Question> questions = new LinkedList<Question>();
		try {
			Criteria crit = session.createCriteria(Question.class);
			crit.add(Restrictions.eq("test", test));
			crit.setFirstResult((page - 1) * maxQuestions);
			crit.setMaxResults(maxQuestions);
			questions = crit.list();
			if (questions.get(0).getAnswers().size() > 0) {
				for (Answer answer : questions.get(0).getAnswers())
					answer.getAnswerText();
			}
		} catch (HibernateException e) {
			logger.error("getAllTestNames in test ERROR \n" + e);
			throw new DaoException(e);
		}
		return questions;
	}

	public int getCountQuestionsByTestId(int testId) throws DaoException {
		int countValue;
		try {
			Session session = HibernateUtil.getInstance().getSession();
			String hql = "SELECT count(idQuestion) from Question where Test_idTest=:testId";
			Query query = session.createQuery(hql);
			query.setParameter("testId", testId);
			System.out.println(hql);
			countValue = ((Number) query.uniqueResult()).intValue();
		} catch (HibernateException e) {
			logger.error("Error " + e);
			throw new DaoException(e);
		}
		return countValue;
	}
}
