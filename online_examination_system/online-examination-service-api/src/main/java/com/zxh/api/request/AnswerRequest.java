package com.zxh.api.request;

public class AnswerRequest {

	// 题目id
	Integer subjectId;

	// 选项
	String option;

	public Integer getSubjectId() {
		return subjectId;
	}

	public AnswerRequest setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
		return this;
	}

	public String getOption() {
		return option;
	}

	public AnswerRequest setOption(String option) {
		this.option = option;
		return this;
	}

}
