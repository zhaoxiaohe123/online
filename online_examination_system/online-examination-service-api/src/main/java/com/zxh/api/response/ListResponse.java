package com.zxh.api.response;

public class ListResponse<T> {

	// 是否为第一页
	boolean isFirstPage = false;
	// 是否为最后一页
	boolean isLastPage = false;
	// 是否有前一页
	boolean hasPreviousPage = false;
	// 是否有下一页
	boolean hasNextPage = false;

	T data;

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public ListResponse<T> setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
		return this;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public ListResponse<T> setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
		return this;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public ListResponse<T> setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
		return this;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public ListResponse<T> setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
		return this;
	}

	public T getData() {
		return data;
	}

	public ListResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

}
