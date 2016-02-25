package entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Tumilovich.D DTO Object contains objects for our page answTest.jsp
 */
public class QuestionDTO {
	/**
	 * Questions is List {@link entity.Question} for one *.jsp page
	 */
	private List<Question> questions = new LinkedList<Question>();
	/**
	 * value of current page
	 */
	private int page;
	/**
	 * value of remaining pages to end of test
	 */
	private int remainPage;

	/**
	 * 
	 * @param question
	 *            {@link entity.QuestionDTO#questions}
	 * @param page
	 *            {@link entity.QuestionDTO#page}
	 * @param remainPage
	 *            {@link entity.QuestionDTO#remainPage}
	 */
	
	public QuestionDTO(List<Question> question, int page, int remainPage) {
		this.questions = question;
		this.page = page;
		this.remainPage = remainPage;
	}

	public QuestionDTO() {
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRemainPage() {
		return remainPage;
	}

	public void setRemainPage(int remainPage) {
		this.remainPage = remainPage;
	}

}
