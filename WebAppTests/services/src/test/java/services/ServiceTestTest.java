package services;

import java.io.Serializable;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import impl.IServiceTest;

@Transactional
@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTestTest {
	@Autowired
	IServiceTest servicetest;

	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addGetTest() {
		Serializable id;
		entity.Test test1 = new entity.Test("Junit subject", "Juint name");
		entity.Test test2 = null;
		id = servicetest.addTest(test1);
		test2 = servicetest.getTest((int)id);
		Assert.assertEquals("Error  addGetTest ", test1, test1);
	}

}
