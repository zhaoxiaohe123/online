package com.zxh.response;

public class ScoreResponse {

	Integer maxScore;

	Integer minScore;

	String avgScore;

	public Integer getMaxScore() {
		return maxScore;
	}

	public ScoreResponse setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
		return this;
	}

	public Integer getMinScore() {
		return minScore;
	}

	public ScoreResponse setMinScore(Integer minScore) {
		this.minScore = minScore;
		return this;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public ScoreResponse setAvgScore(String avgScore) {
		this.avgScore = avgScore;
		return this;
	}

}
