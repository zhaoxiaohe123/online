package com.zxh.api.request;

public class UserPaperScore {

	
	String score;
	
	String daan;
	
	String id;
	
	String userid;
	
	String userpaperid;
	
	

	public String getUserpaperid() {
		return userpaperid;
	}

	public UserPaperScore setUserpaperid(String userpaperid) {
		this.userpaperid = userpaperid;
		return this;
	}

	public String getUserid() {
		return userid;
	}

	public UserPaperScore setUserid(String userid) {
		this.userid = userid;
		return this;
	}

	public String getScore() {
		return score;
	}

	public UserPaperScore setScore(String score) {
		this.score = score;
		return this;
	}

	public String getDaan() {
		return daan;
	}

	public UserPaperScore setDaan(String daan) {
		this.daan = daan;
		return this;
	}

	public String getId() {
		return id;
	}

	public UserPaperScore setId(String id) {
		this.id = id;
		return this;
	}
	
	
}
