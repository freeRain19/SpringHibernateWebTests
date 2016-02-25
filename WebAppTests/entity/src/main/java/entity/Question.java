package entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
/**
 * 
 * @author Tumilovich.D
 *	Entity Question contains List {@link entity.Answer} and  question text 
 */
@Entity
@Table(name = "question")
public class Question {
	public Question() {
	}

	public Question(String textQuestion, Test test) {
		this.textQuestion = textQuestion;
		this.test = test;
	}

	public Question(String textQuestion, List<Answer> answers) {
		this.textQuestion = textQuestion;
		this.answers = answers;
	}

	public Question(String textQuestion) {
		this.textQuestion = textQuestion;
	}
/**
 *  - id from Question table
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idQuestion")
	private int idQuestion;
/**
 * - text of question
 */
	
	@Column(name = "Question_text")
	private String textQuestion;
/**
 *  {@link entity.Answer} List  of this question
 */
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "question")
	List<Answer> answers = new LinkedList<>();
/**
 * {@link entity.Test} that contains this Question
 */
	@ManyToOne
	@JoinColumn(name = "Test_idTest")
	private Test test;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getTextQuestion() {
		return textQuestion;
	}

	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "idQuestion =" + idQuestion + "\ttextQuestion ----------->"
				+ textQuestion;
	}
}
