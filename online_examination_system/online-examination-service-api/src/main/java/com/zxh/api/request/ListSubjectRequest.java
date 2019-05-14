package com.zxh.api.request;

public class ListSubjectRequest {

	// 试题类型
	String type;

	// 试题难度
	String difficulty;

	// 所属状态
	String state;

	int pageSize;

	int pageNum;

	public String getType() {
		return type;
	}

	public ListSubjectRequest setType(String type) {
		this.type = type;
		return this;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public ListSubjectRequest setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getState() {
		return state;
	}

	public ListSubjectRequest setState(String state) {
		this.state = state;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ListSubjectRequest setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public ListSubjectRequest setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return this;
	}

}
