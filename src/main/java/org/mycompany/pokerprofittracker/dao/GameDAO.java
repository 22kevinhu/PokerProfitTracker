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
			statement = conn.prepareStatement("INSERT INTO games (owner_id, profit, game_played) VALUES (?, ?, ?)");

			statement.setInt(1, game.getOwnerId());
			statement.setDouble(2, game.getProfit());
			statement.setString(3, game.getGamePlayed());

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

	public void updateGame(Game game) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = ConnectionPool.getConnection();
			statement = conn.prepareStatement("UPDATE games SET profit = ?, game_played = ? WHERE id = ?");

			statement.setDouble(1, game.getProfit());
			statement.setString(2, game.getGamePlayed());
			statement.setInt(3, game.getGameId());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					ConnectionPool.closeConnection(conn);
					statement.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
