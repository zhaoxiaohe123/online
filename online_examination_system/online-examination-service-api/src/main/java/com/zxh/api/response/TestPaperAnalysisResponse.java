package com.zxh.api.response;

public class TestPaperAnalysisResponse {

	// 最高分数
	Integer maxScore;

	// 最低分数
	Integer minScore;

	// 平均分
	String average;

	// 及格人数
	Integer passPerson;

	// 总人数
	Integer totalPerson;

	public Integer getMaxScore() {
		return maxScore;
	}

	public TestPaperAnalysisResponse setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
		return this;
	}

	public Integer getMinScore() {
		return minScore;
	}

	public TestPaperAnalysisResponse setMinScore(Integer minScore) {
		this.minScore = minScore;
		return this;
	}

	public String getAverage() {
		return average;
	}

	public TestPaperAnalysisResponse setAverage(String average) {
		this.average = average;
		return this;
	}

	public Integer getPassPerson() {
		return passPerson;
	}

	public TestPaperAnalysisResponse setPassPerson(Integer passPerson) {
		this.passPerson = passPerson;
		return this;
	}

	public Integer getTotalPerson() {
		return totalPerson;
	}

	public TestPaperAnalysisResponse setTotalPerson(Integer totalPerson) {
		this.totalPerson = totalPerson;
		return this;
	}

}
