package org.mycompany.pokerprofittracker.dao;

import org.mycompany.pokerprofittracker.model.Game;
import org.mycompany.pokerprofittracker.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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

	public void updateGame(int gameId, double profit) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = ConnectionPool.getConnection();
			statement = conn.prepareStatement("UPDATE games SET profit = ? WHERE id = ?");

			statement.setDouble(1, profit);
			statement.setInt(2, gameId);

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

	public List<Game> getAllGames() {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		List<Game> games = new LinkedList<>();

		try {
			conn = ConnectionPool.getConnection();
			String query = "SELECT id, owner_id, profit, game_played FROM games";
			statement = conn.prepareStatement(query);
			rs = statement.executeQuery();

			while (rs.next()) {
				int gameId = rs.getInt("id");
				int ownerId = rs.getInt("owner_id");
				double profit = rs.getDouble("profit");
				String gamePlayed = rs.getString("game_played");
				Game game = new Game(gameId, ownerId, profit, gamePlayed);
				games.add(game);
			}
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
		return games;
	}
}
