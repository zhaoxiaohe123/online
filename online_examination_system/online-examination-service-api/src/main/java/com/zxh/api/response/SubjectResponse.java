package com.zxh.api.response;

public class SubjectResponse {

	Integer id;

	// 试题类型
	String type;

	// 试题难度
	String difficulty;

	// 所属状态
	String state;

	// 题干
	String stem;

	public Integer getId() {
		return id;
	}

	public SubjectResponse setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public SubjectResponse setType(String type) {
		this.type = type;
		return this;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public SubjectResponse setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getState() {
		return state;
	}

	public SubjectResponse setState(String state) {
		this.state = state;
		return this;
	}

	public String getStem() {
		return stem;
	}

	public SubjectResponse setStem(String stem) {
		this.stem = stem;
		return this;
	}

}
