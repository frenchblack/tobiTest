package com.spring.tobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.tobi.bean.User;
import com.spring.tobi.connectionmaker.ConnectionMaker;

public class MessageDao {
	private ConnectionMaker connectionMaker;
	
	public MessageDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makerConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?,?,?)"		
		);
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makerConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"SELECT * FROM USERS WHERE ID = ?"		
		);
		
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("ID"));
		user.setName(rs.getString("NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		
		rs.close();
		ps.close();
		c.close();
				
		return user;
	}
}
