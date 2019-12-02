package com.spring.tobi.daofactory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.spring.tobi.connectionmaker.ConnectionMaker;
import com.spring.tobi.connectionmaker.CountingConnectionMaker;
import com.spring.tobi.connectionmaker.DConnectionMaker;
import com.spring.tobi.dao.UserDao;

@Configuration
public class CountingDaoFactory {
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(org.mariadb.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mariadb://localhost:3306/tobi");
		dataSource.setUsername("TOBI_TEST");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}
