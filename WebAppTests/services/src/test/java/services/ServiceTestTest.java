package services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.*;

public class ServiceTestTest {
	@Autowired
	ServiceTest servicetest;

	// @Test
	public void addGetTest() {
		int id;
		entity.Test test1 = new entity.Test("Junit name", "Juint name");
		entity.Test test2 = null;
		id = (int) servicetest.addTest(test1);
		test2 = servicetest.getTest(id);
		Assert.assertEquals("Error  addGetTest ", test1, test2);
	}

}
