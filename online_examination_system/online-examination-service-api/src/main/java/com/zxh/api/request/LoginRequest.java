package com.zxh.api.request;

public class LoginRequest {

	String account;
	
	String passWord;

	public String getAccount() {
		return account;
	}

	public LoginRequest setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassWord() {
		return passWord;
	}

	public LoginRequest setPassWord(String passWord) {
		this.passWord = passWord;
		return this;
	}
	
	
	
}
