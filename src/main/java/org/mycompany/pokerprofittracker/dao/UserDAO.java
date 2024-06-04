package org.mycompany.pokerprofittracker.dao;

import org.mycompany.pokerprofittracker.model.User;
import org.mycompany.pokerprofittracker.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = ConnectionPool.getConnection();
			String query = "INSERT INTO users (name, totalGambled) VALUES (?, ?)";
			statement = conn.prepareStatement(query);
			statement.setString(1, user.getUserName());
			statement.setDouble(2, user.getTotalSpent());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
					ConnectionPool.closeConnection(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	public List<User> getAllUsers() {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<User> users = new LinkedList<>();
		String query = "SELECT * FROM users";

		try {
			conn = ConnectionPool.getConnection();
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("name");
				double totalGambled = resultSet.getDouble("totalGambled");
				users.add(new User(userId, userName, totalGambled));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if (statement != null) {
					ConnectionPool.closeConnection(conn);
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
