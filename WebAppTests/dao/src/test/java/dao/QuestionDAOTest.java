package dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import dao.impl.*;
import entity.*;
import exceptions.DaoException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration("/beans-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionDAOTest {
	private static Logger log = Logger.getLogger(QuestionDAOTest.class);

	@Autowired
	QuestionDAO questionDao;
	@Autowired
	TestDAO testDao;

	@Test
	public void questionDaoTest() {
		Serializable id;
		Question question = null;
		question = new Question("Question new ");
		Question question1 = null;
		List<Answer> answers;
		answers = new LinkedList<>();
		try {
			question.setTest(testDao.get(2));
			answers.add(new Answer("create answer1", (byte) 1, question));
			answers.add(new Answer("create answer22", (byte) 0, question));
			answers.add(new Answer("create answer33", (byte) 0, question));
			question.setAnswers(answers);
			id = questionDao.save(question);
			question1 = questionDao.get(id);
		} catch (Exception e) {
			log.error("QuestionDAOImplTest exception \n" + e);
		}
		Assert.assertEquals("Question question1=question",question, question1);
	}

	 @Test
	public void testQuestion() throws DaoException {
		List<Question> questions = new LinkedList<Question>();
		int count = questionDao.getCountQuestionsByTestId(testDao.get(8).getIdTest());
		System.out.println("ALL COUNT  questions = " + count);
		for (int i = 1; i <= count; i++) {
			try {
				questions = questionDao.getQuestionPage(i, testDao.get(8), 1);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			for (Question question : questions) {
				System.out.println(questions);
				for (Answer answer : question.getAnswers())
					System.out.println("\t" + answer);
			}
		}
		Assert.assertEquals(3, count);
	}
}
