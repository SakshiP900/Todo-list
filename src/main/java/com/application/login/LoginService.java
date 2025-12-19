package com.application.login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if (user.equals("user") && password.equals("12345")) {
			return true;
		}
		return false;
	}

}
