package com.zxh.api.request;

public class AddAnswerRequest {

	// 选项
	String option;

	// 内容
	String content;

	// 是否正确答案
	Boolean flag;


	public String getOption() {
		return option;
	}

	public AddAnswerRequest setOption(String option) {
		this.option = option;
		return this;
	}

	public String getContent() {
		return content;
	}

	public AddAnswerRequest setContent(String content) {
		this.content = content;
		return this;
	}

	public Boolean getFlag() {
		return flag;
	}

	public AddAnswerRequest setFlag(Boolean flag) {
		this.flag = flag;
		return this;
	}

}
