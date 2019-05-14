package com.zxh.api.request;

import java.util.List;

public class AddUserAnswerRequest {
	
	//用户考试id
	String userPaperId;

	//用户回答id
	List<AnswerRequest> answers;

	public String getUserPaperId() {
		return userPaperId;
	}

	public AddUserAnswerRequest setUserPaperId(String userPaperId) {
		this.userPaperId = userPaperId;
		return this;
	}

	public List<AnswerRequest> getAnswers() {
		return answers;
	}

	public AddUserAnswerRequest setAnswers(List<AnswerRequest> answers) {
		this.answers = answers;
		return this;
	}

}
