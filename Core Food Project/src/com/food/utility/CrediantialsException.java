package com.food.utility;

public class CrediantialsException extends RuntimeException {

	private static final long serialVersionUID = -4539462079078547287L;
	String username = "";

	public CrediantialsException(String username) {
		this.username = username;
	}

	@Override
	public String getMessage() {
		return "🟠 Please check your credentials , " + username + " Not Found or Incorrect Password .";
	}

	@Override
	public String toString() {
		return getMessage() + "🟠 Entered the crediantials didnt match ";
	}

}
