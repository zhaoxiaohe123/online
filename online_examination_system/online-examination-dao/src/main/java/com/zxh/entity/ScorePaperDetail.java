package com.zxh.entity;

import java.io.Serializable;

public class ScorePaperDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String score;
	
	String daan;
	
	String id;

	public String getScore() {
		return score;
	}

	public ScorePaperDetail setScore(String score) {
		this.score = score;
		return this;
	}

	public String getDaan() {
		return daan;
	}

	public ScorePaperDetail setDaan(String daan) {
		this.daan = daan;
		return this;
	}

	public String getId() {
		return id;
	}

	public ScorePaperDetail setId(String id) {
		this.id = id;
		return this;
	}
}
