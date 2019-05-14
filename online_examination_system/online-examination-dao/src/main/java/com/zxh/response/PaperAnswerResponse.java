package com.zxh.response;

public class PaperAnswerResponse {

	String answerId;

	// 选项
	String option;

	// 内容
	String content;

	String flag;

	public String getFlag() {
		return flag;
	}

	public PaperAnswerResponse setFlag(String flag) {
		this.flag = flag;
		return this;
	}

	public String getAnswerId() {
		return answerId;
	}

	public PaperAnswerResponse setAnswerId(String answerId) {
		this.answerId = answerId;
		return this;
	}

	public String getOption() {
		return option;
	}

	public PaperAnswerResponse setOption(String option) {
		this.option = option;
		return this;
	}

	public String getContent() {
		return content;
	}

	public PaperAnswerResponse setContent(String content) {
		this.content = content;
		return this;
	}

}
