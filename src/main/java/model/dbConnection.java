package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/mytodos ";
	private static final String USERNAME = "Enter Your username";
	private static final String PASSWORD = "Enter Your password";

	public static Connection getConnection() throws ClassNotFoundException {

		System.out.println("Connection initiated");

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
