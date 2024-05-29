package org.mycompany.pokerprofittracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/userData";
	private static final String MYSQL_USER = "root";
	private static final String MYSQL_PASSWORD = "0127";

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			// Loads the MySQL JDBC Driver
			System.out.println("Connecting to database...");
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
			System.out.println("Successfully connected to database!");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC driver!" + e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}
