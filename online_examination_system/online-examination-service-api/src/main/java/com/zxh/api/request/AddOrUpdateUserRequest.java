package com.zxh.api.request;

public class AddOrUpdateUserRequest {

	// 主键
	String id;

	// 账号
	String account;

	// 密码
	String passWord;

	// 角色
	String role;

	public String getId() {
		return id;
	}

	public AddOrUpdateUserRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getAccount() {
		return account;
	}

	public AddOrUpdateUserRequest setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassWord() {
		return passWord;
	}

	public AddOrUpdateUserRequest setPassWord(String passWord) {
		this.passWord = passWord;
		return this;
	}

	public String getRole() {
		return role;
	}

	public AddOrUpdateUserRequest setRole(String role) {
		this.role = role;
		return this;
	}

}
