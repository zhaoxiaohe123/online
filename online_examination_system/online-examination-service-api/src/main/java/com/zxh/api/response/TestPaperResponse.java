package com.zxh.api.response;

import java.util.Date;

public class TestPaperResponse {

	String id;

	String name;

	String state;

	String type;

	// 开考时间
	Date startTime;

	// 结束时间
	Date endTime;

	// 卷面总分
	Integer totalScore;

	// 参考人数
	Integer totalPerson;

	public String getId() {
		return id;
	}

	public TestPaperResponse setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TestPaperResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return state;
	}

	public TestPaperResponse setState(String state) {
		this.state = state;
		return this;
	}

	public String getType() {
		return type;
	}

	public TestPaperResponse setType(String type) {
		this.type = type;
		return this;
	}

	public Date getStartTime() {
		return startTime;
	}

	public TestPaperResponse setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public TestPaperResponse setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public TestPaperResponse setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}

	public Integer getTotalPerson() {
		return totalPerson;
	}

	public TestPaperResponse setTotalPerson(Integer totalPerson) {
		this.totalPerson = totalPerson;
		return this;
	}

}
