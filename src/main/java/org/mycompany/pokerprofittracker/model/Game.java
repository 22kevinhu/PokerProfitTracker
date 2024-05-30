package org.mycompany.pokerprofittracker.model;

public class Game {
	private final int ownerId;
	private double profit;
	private String gamePlayed;

	public Game(int ownerId, double profit, String gamePlayed) {
		this.ownerId = ownerId;
		this.profit = profit;
		this.gamePlayed = gamePlayed;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(String gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
}
