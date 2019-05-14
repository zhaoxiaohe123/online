package com.zxh.response;

public class PaperSubjectResponse {

	Integer subjectId;

	// 试题类型
	String type;

	// 试题难度
	String difficulty;

	// 题干
	String stem;

	String content;

	public String getContent() {
		return content;
	}

	public PaperSubjectResponse setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public PaperSubjectResponse setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
		return this;
	}

	public String getType() {
		return type;
	}

	public PaperSubjectResponse setType(String type) {
		this.type = type;
		return this;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public PaperSubjectResponse setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getStem() {
		return stem;
	}

	public PaperSubjectResponse setStem(String stem) {
		this.stem = stem;
		return this;
	}

}
