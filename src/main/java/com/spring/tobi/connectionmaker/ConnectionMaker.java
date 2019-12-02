package com.spring.tobi.connectionmaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
	public Connection makerConnection() throws ClassNotFoundException, SQLException;
}
