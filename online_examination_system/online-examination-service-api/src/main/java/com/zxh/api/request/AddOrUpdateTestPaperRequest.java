package com.zxh.api.request;

public class AddOrUpdateTestPaperRequest {

	// id
	String id;

	// 名称
	String name;

	// 试卷类型
	String type;

	// 考试状态
	String state;

	// 开考时间
	long startTime;

	// 结束时间
	long endTime;

	// 公布时间
	long publicTime;

	// 卷面总分
	Integer totalScore;

	// 及格分数
	Integer passScore;

	// 试卷说明
	String explain;

	public String getId() {
		return id;
	}

	public AddOrUpdateTestPaperRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public AddOrUpdateTestPaperRequest setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddOrUpdateTestPaperRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return state;
	}

	public AddOrUpdateTestPaperRequest setState(String state) {
		this.state = state;
		return this;
	}

	public long getStartTime() {
		return startTime;
	}

	public AddOrUpdateTestPaperRequest setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}

	public long getEndTime() {
		return endTime;
	}

	public AddOrUpdateTestPaperRequest setEndTime(long endTime) {
		this.endTime = endTime;
		return this;
	}

	public long getPublicTime() {
		return publicTime;
	}

	public AddOrUpdateTestPaperRequest setPublicTime(long publicTime) {
		this.publicTime = publicTime;
		return this;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public AddOrUpdateTestPaperRequest setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public AddOrUpdateTestPaperRequest setPassScore(Integer passScore) {
		this.passScore = passScore;
		return this;
	}

	public String getExplain() {
		return explain;
	}

	public AddOrUpdateTestPaperRequest setExplain(String explain) {
		this.explain = explain;
		return this;
	}

}
