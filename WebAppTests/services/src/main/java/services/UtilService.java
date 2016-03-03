package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import dao.impl.UserDAO;
import entity.*;
import impl.IUtilService;

@Service
@Transactional
public class UtilService implements IUtilService {
	static int currentTestId;
	static int currentQuestionId;
	Test currentTest;
	private static final Logger logger = Logger.getLogger(UtilService.class);

	public void setCurrentTest(Test currentTest) {
		this.currentTest = currentTest;
	}
	@Autowired
	UserDAO userDAO;
	public UtilService() {
	}
	public Test getCurrentTest() {
		return currentTest;
	}

	int count = 0;
	int rightCount = 0;
	private float rightPercent = 0.0f;

	public void addResultList(List<Question> questions, List<Byte> answers) {
		int iter = 0;
		for (Question question : questions)
			for (Answer answer : question.getAnswers()) {
				if (answer.getState() == answers.get(iter)) {
					rightCount++;
				}
				iter++;
				count++;
			}
		rightPercent = (float) rightCount / count;
	}

	public int getRightPercent() {
		count = 0;
		rightCount = 0;
		int value = (int) (rightPercent * 100);
		rightPercent = 0;
		return value;
	}

}