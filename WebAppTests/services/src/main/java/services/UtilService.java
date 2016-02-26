package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import dao.impl.UserDAO;
import entity.*;
import impl.IUtilService;

@Service
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

	public int validateUser(String userName, String password) {
		int accessLevel = 0;
		User user = null;
		try {
			user = userDAO.getUserByName(userName, password);
			accessLevel = user.getAccessLevel_idAccessLevel();
		} catch (Exception e) {
			logger.error("get User and password from databse exception \n" + e.toString());
			return 0;
		}
		return accessLevel;
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
		System.out.println("count =" + count);
		count = 0;
		rightCount = 0;
		int value = (int) (rightPercent * 100);
		rightPercent = 0;
		System.out.println("Percent = " + value);
		return value;
	}

}