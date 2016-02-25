package entity;

import javax.persistence.*;

/**
 * @author Tumilovich.D 
 * Entity Answer contains Answer text and this state
 */
@Entity
@Table(name = "answer")
public class Answer {
	public Answer() {

	}

	/**
	 * idAnswer contain id from table Answer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAnswer")
	private int idAnswer;
	/**
	 * Answer text
	 */
	@Column(name = "AnswerText")
	private String answerText;
	/**
	 * State this answer - 0/1 byte value 
	 */
	@Column(name = "state")
	private byte state;
	/**
	 * {@link entity.Question} that contains this answer
	 */
	@ManyToOne
	@JoinColumn(name = "Question_idQuestion")
	private Question question;

	/**
	 * 
	 * @param answerText
	 *            {@link Answer#answerText}
	 * @param state
	 *            {@link Answer#state}
	 * @param question
	 *            {@link Answer#question}
	 */
	public Answer(String answerText, byte state, Question question) {
		this.answerText = answerText;
		this.state = state;
		this.question = question;
	}

	public int getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "idAnswer = " + idAnswer + "\tanswerText --  " + answerText + "\tstate  " + state;
	}
}
