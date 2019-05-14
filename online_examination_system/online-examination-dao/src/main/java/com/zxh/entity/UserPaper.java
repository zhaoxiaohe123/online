package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户分数
 * 
 * @author ZXH
 *
 */
public class UserPaper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	String id;

	// 试卷名称
	String name;

	// 用户id
	String userId;

	// 试卷id
	String paperId;

	// 开始时间
	Date startTime;

	// 结束时间
	Date endTime;

	// 考试类型
	String type;

	// 卷面总分
	Integer totalScore;

	// 实际得分
	Integer actualScore;

	// 创建时间
	Date createTime;
	
	

	public Integer getActualScore() {
		return actualScore;
	}

	public UserPaper setActualScore(Integer actualScore) {
		this.actualScore = actualScore;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserPaper setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getPaperId() {
		return paperId;
	}

	public UserPaper setPaperId(String paperId) {
		this.paperId = paperId;
		return this;
	}

	public String getId() {
		return id;
	}

	public UserPaper setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserPaper setName(String name) {
		this.name = name;
		return this;
	}

	public Date getStartTime() {
		return startTime;
	}

	public UserPaper setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public UserPaper setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getType() {
		return type;
	}

	public UserPaper setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public UserPaper setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserPaper setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
