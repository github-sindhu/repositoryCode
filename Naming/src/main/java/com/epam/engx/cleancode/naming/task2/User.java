package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date Birth;

	private String Name;

	private boolean Admin;

	private User[] subordinates;

	private int Rating;

	public User(String Name) {
		super();
		this.Name = Name;
	}

	@Override
	public String toString() {
		return "User [Birth=" + Birth + ", Name=" + Name + ", Admin=" + Admin + ", subordinateArray="
				+ Arrays.toString(subordinates) + ", iRating=" + Rating + "]";
	}

}
