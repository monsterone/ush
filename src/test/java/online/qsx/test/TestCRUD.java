package online.qsx.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import online.qsx.dao.impl.HobbyDaoImpl;
import online.qsx.dao.impl.UserDaoImpl;
import online.qsx.model.UserHobby;
import online.qsx.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext-dao.xml","classpath:applicationContext-server.xml"})
public class TestCRUD {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	
	@Test
	public void testQuery(){
		userDaoImpl.getUsers();
	}
	
	@Test
	public void testSave(){
		userDaoImpl.save(new UserModel("pp","123","123@139.com",true,new Date(),new Date()));
	}

}
