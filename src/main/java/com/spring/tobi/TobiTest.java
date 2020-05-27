package com.spring.tobi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.tobi.bean.User;
import com.spring.tobi.dao.UserDao;

public class TobiTest {

	@Test
	public void addAndget() throws ClassNotFoundException, SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("gyumee");
		user.setName("�ڼ�ö");
		user.setPassword("springno1");
		
		dao.add(user);
		
		System.out.println(user.getId() + "��ϼ���");
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
		
//		if ( !user.getName().equals(user2.getName()) ) {
//			System.out.println("�׽�Ʈ ���� (name)");
//		} else if ( !user.getPassword().equals(user2.getPassword()) ) {
//			System.out.println("�׽�Ʈ ���� (password)");
//		} else {
//			System.out.println("��ȸ �׽�Ʈ ����");
//		}
	}

}
