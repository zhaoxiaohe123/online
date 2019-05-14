package com.zxh.api.request;

public class ListUserPaperRequest {

	String userId;

	String name;

	String type;

	int pageSize;

	int pageNum;

	public String getName() {
		return name;
	}

	public ListUserPaperRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public ListUserPaperRequest setType(String type) {
		this.type = type;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public ListUserPaperRequest setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ListUserPaperRequest setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public ListUserPaperRequest setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return this;
	}

}
