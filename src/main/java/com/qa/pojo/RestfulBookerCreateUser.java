package com.qa.pojo;

public class RestfulBookerCreateUser {

	private String username;
	private String password;

	public RestfulBookerCreateUser(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


}
