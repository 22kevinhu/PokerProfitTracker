package org.mycompany.pokerprofittracker.model;

public class User {
	private String userName;
	private double totalSpent;
	private int userId;

	public User(int userId, String userName, double totalSpent) {
		this.userId = userId;
		this.userName = userName;
		this.totalSpent = totalSpent;
	}

	public User(String userName, double totalSpent) {
		this.userName = userName;
		this.totalSpent = totalSpent;
	}

	public User(String userName) {
		this(userName, 0);
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
