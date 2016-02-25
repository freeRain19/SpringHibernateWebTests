package controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import connect.HibernateUtil;
import entity.QuestionDTO;
import entity.Test;
import services.Service;
import services.ServiceQuestion;
import services.ServiceTest;

@Controller
public class TestController {
	private static final Logger logger = Logger.getLogger(TestController.class);
	ServiceTest serviceTest = ServiceTest.getInstance();
	Service service = Service.getInstance();
	ServiceQuestion serviceQuestion = ServiceQuestion.getInstance();

	@RequestMapping("/selectTest")
	public String selectTest(String idTest, ModelMap model, HttpSession session) {
		System.out.println("idTest - " + idTest);
		String target = "viewtests";
		QuestionDTO qDto = null;
		int id = 0;
		try {

			if (idTest != null) {
				id = Integer.parseInt(idTest);
			} else {
				model.put("tests", serviceTest.getAllTests());
				return target;
			}
			Test test = serviceTest.getTest(id);
			session.setAttribute("currentTest", test);
			qDto = serviceQuestion.getQuestionByTest(1, test);
			session.setAttribute("qDto", qDto);
			target = "answTest";
			logger.info("get test from databse successfully");
		} catch (NullPointerException e) {
			model.put("error", "get test from base Exception");
			target = "Error";
			logger.error("get test from base Exception " + e.getMessage());
		}
		return target;
	}

	@RequestMapping("/inputTest")
	public String inputTest(String subject, String testName, ModelMap model, HttpSession session) {
		String target = "Error";

		Test test = new Test(subject, testName);
		session.setAttribute("currentTest", test);
		int result = (int) serviceTest.addTest(test);
		if (result <= 0) {
			model.put("error", "Input Test  Error");
		} else
			target = "addQuestions";
		return target;
	}

	@RequestMapping("/checkTest")
	public String checkTest(HttpServletRequest request, ModelMap model, String page, String finish) {
		String target = "Error";
		QuestionDTO qDto = (QuestionDTO) request.getSession().getAttribute("qDto");
		Test currentTest = (Test) request.getSession().getAttribute("currentTest");
		List<Byte> results = new LinkedList<>();
		int i = 1;
		while (i <= qDto.getQuestions().size() * 5) {
			if (request.getParameter("answer" + i) != null)
				results.add((byte) 1);
			else
				results.add((byte) (0));
			i++;
		}
		service.addResultList(qDto.getQuestions(), results);

		if (request.getParameter("page") != null) {
			int page1 = Integer.parseInt(request.getParameter("page"));
			QuestionDTO newQuestionDto = serviceQuestion.getQuestionByTest(page1, currentTest);
			model.put("qDto", newQuestionDto);
			target = "answTest";
		}
		if (request.getParameter("finish") != null) {
			int result = service.getRightPercent();
			request.getSession().setAttribute("resultTest", result);
			model.put("tests", serviceTest.getAllTests());
			target = "viewtests";
		}

		return target;
	}

}
