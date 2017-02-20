package kz.azh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/test";
    Connection connection = null;
    private static DBConnection _instance;
	
	static final String USER = "postgres";
	static final String PASS = "postgres";
	
	private DBConnection(){
		try {
    		Class.forName(JDBC_DRIVER);
    		connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}		
	}
	
	public static DBConnection getter() {
		if(_instance == null)
			_instance = new DBConnection();
		return _instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
