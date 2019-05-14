package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户分数详情
 * 
 * @author ZXH
 *
 */
public class UserPaperDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;

	// 用户考试id
	String userPaperId;

	// 题目id
	Integer subjectId;

	// 学生回答
	String answer;

	// 此题得分情况
	Integer score;

	// 创建时间
	Date createTime;
	
	String zhuguanti;
	
	

	public String getZhuguanti() {
		return zhuguanti;
	}

	public UserPaperDetail setZhuguanti(String zhuguanti) {
		this.zhuguanti = zhuguanti;
		return this;
	}

	public String getId() {
		return id;
	}

	public UserPaperDetail setId(String id) {
		this.id = id;
		return this;
	}

	public String getUserPaperId() {
		return userPaperId;
	}

	public UserPaperDetail setUserPaperId(String userPaperId) {
		this.userPaperId = userPaperId;
		return this;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public UserPaperDetail setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
		return this;
	}

	public String getAnswer() {
		return answer;
	}

	public UserPaperDetail setAnswer(String answer) {
		this.answer = answer;
		return this;
	}

	public Integer getScore() {
		return score;
	}

	public UserPaperDetail setScore(Integer score) {
		this.score = score;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserPaperDetail setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
