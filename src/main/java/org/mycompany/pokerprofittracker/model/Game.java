package org.mycompany.pokerprofittracker.model;

public class Game {
	private final int ownerId;
	private double profit;

	public Game(int ownerId, double profit) {
		this.ownerId = ownerId;
		this.profit = profit;
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
}
