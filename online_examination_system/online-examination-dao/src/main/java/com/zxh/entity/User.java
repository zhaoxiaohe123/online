package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author ZXH
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	String id;

	// 账号
	String account;

	// 密码
	String passWord;

	// 角色
	String role;

	// 创建时间
	Date createTime;

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public String getAccount() {
		return account;
	}

	public User setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassWord() {
		return passWord;
	}

	public User setPassWord(String passWord) {
		this.passWord = passWord;
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
