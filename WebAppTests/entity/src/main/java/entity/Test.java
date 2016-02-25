package entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

/**
 * @author Tumilovich.D Entity Test contain all information about test
 */
@Entity
@Table(name = "test")
public class Test {
	public Test() {
	}

	public Test(String nameSubject, String testName) {
		this.nameSubject = nameSubject;
		this.testName = testName;
	}

	/**
	 * idTest id this Test id database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTest")
	private int idTest;
	/**
	 * Subject name current test
	 */
	@Column(name = "nameSubject")
	private String nameSubject;
	/**
	 * Name of Test
	 */
	@Column(name = "testName")
	private String testName;

	/**
	 * Contains List {@link entity.Question} of this Test
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
	List<Question> questions = new LinkedList<>();

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	@Override
	public String toString() {
		return "id test = " + idTest + "\tnameSubject = " + nameSubject + "\ttestName = " + testName;
	}
}
