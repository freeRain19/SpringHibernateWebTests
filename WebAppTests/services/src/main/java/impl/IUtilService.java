package impl;

import java.util.List;

import entity.Question;

public interface IUtilService {
	//int validateUser(String userName, String password) ;
	void addResultList(List<Question> questions, List<Byte> answers);
	public int getRightPercent();
}
