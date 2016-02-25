package services;




import java.util.List;
import org.hibernate.*;
import connect.HibernateUtil;
import org.apache.log4j.Logger;
import dao.*;
import entity.*;


public class Service {
	static int currentTestId;
	static int currentQuestionId;
	Test currentTest;
	private static final Logger logger = Logger.getLogger(Service.class);
	private Transaction transaction = null;

	public void setCurrentTest(Test currentTest) {
		this.currentTest = currentTest;
	}
	
	UserDAOImpl userDAO = UserDAOImpl.getInstance();
	TestDAOImpl testDAO = TestDAOImpl.getInstance();
	QuestionDAOImpl questDAO = QuestionDAOImpl.getInstance();
	private static Service instance;

	private Service() {
	}

	public static synchronized Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public Test getCurrentTest() {
		return currentTest;
	}

	public int validateUser(String userName, String password) {
		int accessLevel = 0;
		User user = null;
		try {
			//Session session = HibernateUtil.getInstance().getSession();
			//transaction = session.beginTransaction();
			user = userDAO.getUserByName(userName, password);
			accessLevel = user.getAccessLevel_idAccessLevel();
			//transaction.commit();
		} catch (Exception e) {
			//transaction.rollback();
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
		System.out.println("count ="+count);
		count = 0;
		rightCount=0;
		int value = (int) (rightPercent * 100);
		rightPercent = 0;
		System.out.println("Percent = "+value);
		return value;
	}

}