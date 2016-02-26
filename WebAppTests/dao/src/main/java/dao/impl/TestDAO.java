package dao.impl;


import java.util.List;
import org.springframework.stereotype.Repository;
import entity.Test;
import exceptions.DaoException;


public interface TestDAO extends Dao<Test> {
	public List<Test> getAllTestNames() throws DaoException;
}
