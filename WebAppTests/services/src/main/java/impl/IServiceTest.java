package impl;

import java.io.Serializable;
import java.util.List;

import entity.Test;

public interface IServiceTest {
	public List<Test> getAllTests();
	public Serializable addTest(Test test) ;
	public Test getTest(int idTest);
}
