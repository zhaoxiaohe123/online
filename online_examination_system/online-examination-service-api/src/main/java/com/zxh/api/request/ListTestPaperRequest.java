package com.zxh.api.request;

public class ListTestPaperRequest {

	String name;

	String state;

	String type;

	int pageSize;

	int pageNum;

	public String getName() {
		return name;
	}

	public ListTestPaperRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return state;
	}

	public ListTestPaperRequest setState(String state) {
		this.state = state;
		return this;
	}

	public String getType() {
		return type;
	}

	public ListTestPaperRequest setType(String type) {
		this.type = type;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ListTestPaperRequest setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public ListTestPaperRequest setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return this;
	}

}
