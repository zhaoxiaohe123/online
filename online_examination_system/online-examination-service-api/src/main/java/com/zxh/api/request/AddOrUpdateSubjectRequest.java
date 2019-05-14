package com.zxh.api.request;

import java.util.List;

public class AddOrUpdateSubjectRequest {

	// 主键
	Integer id;

	// 试题类型
	String type;

	// 试题难度
	String difficulty;

	// 所属状态
	String state;

	// 题干
	String stem;

	String answer;

	// 题目解析
	String content;

	// 答案列表
	List<AddAnswerRequest> answerList;

	public Integer getId() {
		return id;
	}

	public AddOrUpdateSubjectRequest setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public AddOrUpdateSubjectRequest setType(String type) {
		this.type = type;
		return this;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public AddOrUpdateSubjectRequest setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getState() {
		return state;
	}

	public AddOrUpdateSubjectRequest setState(String state) {
		this.state = state;
		return this;
	}

	public String getStem() {
		return stem;
	}

	public AddOrUpdateSubjectRequest setStem(String stem) {
		this.stem = stem;
		return this;
	}

	public String getAnswer(){
		return answer;
	}

	public AddOrUpdateSubjectRequest setAnswer(String answer){
		this.answer = answer;
		return this;
	}

	public String getContent() {
		return content;
	}

	public AddOrUpdateSubjectRequest setContent(String content) {
		this.content = content;
		return this;
	}

	public List<AddAnswerRequest> getAnswerList() {
		return answerList;
	}

	public AddOrUpdateSubjectRequest setAnswerList(List<AddAnswerRequest> answerList) {
		this.answerList = answerList;
		return this;
	}

}
