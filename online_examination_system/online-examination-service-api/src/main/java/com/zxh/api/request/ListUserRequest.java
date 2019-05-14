package com.zxh.api.request;

public class ListUserRequest {

	String role;

	int pageNum;

	int pageSize;

	public String getRole() {
		return role;
	}

	public ListUserRequest setRole(String role) {
		this.role = role;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public ListUserRequest setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ListUserRequest setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

}
