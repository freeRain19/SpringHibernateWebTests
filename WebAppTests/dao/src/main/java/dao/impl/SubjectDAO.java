package dao.impl;

import java.sql.ResultSet;

public interface SubjectDAO {
	public void addSubject(String subjectName);

	public ResultSet selectSubject(String listFields, String field, String symbol, int val);

	public void updateSubject(String field, String value, int id);

	public void deleteSubject(int id);
}
