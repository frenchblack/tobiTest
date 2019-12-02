package com.spring.tobi.connectionmaker;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {
	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	@Override
	public Connection makerConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		return realConnectionMaker.makerConnection();
	}
	
	public int getCounter() {
		return this.counter;
	}


}
