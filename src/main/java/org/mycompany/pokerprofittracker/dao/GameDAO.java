package org.mycompany.pokerprofittracker.dao;

import org.mycompany.pokerprofittracker.model.Game;
import org.mycompany.pokerprofittracker.model.User;
import org.mycompany.pokerprofittracker.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
	public void addGame(Game game) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = ConnectionPool.getConnection();
			statement = conn.prepareStatement("INSERT INTO games (owner_id, profit) VALUES (?, ?)");

			statement.setInt(1, game.getOwnerId());
			statement.setDouble(2, game.getProfit());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					ConnectionPool.closeConnection(conn);
					statement.close();
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

		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";

		try {
			conn = ConnectionPool.getConnection();
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String userName = resultSet.getString("name");
				double totalGambled = resultSet.getDouble("totalGambled");
				users.add(new User(id, userName, totalGambled));
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
