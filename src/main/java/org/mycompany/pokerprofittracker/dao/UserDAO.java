package org.mycompany.pokerprofittracker.dao;

import org.mycompany.pokerprofittracker.model.User;
import org.mycompany.pokerprofittracker.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = ConnectionPool.getConnection();
			String query = "INSERT INTO users (name, totalGambled) VALUES (Kevin, 2.0)";
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
}
