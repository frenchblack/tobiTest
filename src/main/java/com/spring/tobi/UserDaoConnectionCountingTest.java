package com.spring.tobi;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.tobi.bean.User;
import com.spring.tobi.connectionmaker.CountingConnectionMaker;
import com.spring.tobi.dao.UserDao;
import com.spring.tobi.daofactory.CountingDaoFactory;

public class UserDaoConnectionCountingTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회성공");
		
		CountingConnectionMaker cmm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + cmm.getCounter());
	}

}
