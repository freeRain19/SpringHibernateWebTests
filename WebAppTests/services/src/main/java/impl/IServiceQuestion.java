package impl;

import java.io.Serializable;

import entity.Question;
import entity.QuestionDTO;
import entity.Test;

public interface IServiceQuestion {
	public QuestionDTO getQuestionByTest(int page, Test test);
	public Serializable addQuestion(Question question);
}
