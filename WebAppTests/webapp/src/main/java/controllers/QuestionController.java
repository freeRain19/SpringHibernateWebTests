package controllers;

import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.*;
import impl.IServiceQuestion;

@Controller
public class QuestionController {
	@Autowired
	IServiceQuestion serviceQuestion;
	private static final Logger logger = Logger.getLogger(QuestionController.class);

	@RequestMapping("/addQuestion")
	public String addQuestion(ModelMap model, String textQuestion, HttpServletRequest request) {
		String textAnsw;
		String redir;
		byte state;
		Test currentTest = (Test) request.getSession().getAttribute("currentTest");
		LinkedList<Answer> answers = new LinkedList<>();
		Question question = new Question(textQuestion, currentTest);
		for (int i = 1; i <= 5; i++) {
			textAnsw = request.getParameter("textAnswer" + i);
			state = (byte) Integer.parseInt(request.getParameter("state" + i));
			answers.add(new Answer(textAnsw, state, question));
		}
		question.setAnswers(answers);
		int result = (int) serviceQuestion.addQuestion(question);
		if (result == 0) {
			model.put("error", "Input questions Error");
			redir = "Error";
		}
		redir = "addQuestions";

		return redir;
	}
}
