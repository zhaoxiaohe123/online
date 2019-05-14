package com.zxh.api.request;

public class GetUserScoreRequest {

	String userId;

	String paperId;

	public String getUserId() {
		return userId;
	}

	public GetUserScoreRequest setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getPaperId() {
		return paperId;
	}

	public GetUserScoreRequest setPaperId(String paperId) {
		this.paperId = paperId;
		return this;
	}

}
