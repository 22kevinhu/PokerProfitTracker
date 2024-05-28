package org.mycompany.pokerprofittracker.model;

public class User {
	private String userName;
	private double totalSpent;

	public User(String userName) {
		this.userName = userName;
		totalSpent = 0;
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
