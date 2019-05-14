package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 试卷
 * 
 * @author ZXH
 *
 */
public class TestPaper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	String id;

	// 名称
	String name;

	// 试卷类型
	String type;

	// 考试状态
	String state;

	// 开考时间
	Date startTime;

	// 结束时间
	Date endTime;

	// 公布时间
	Date publicTime;

	// 卷面总分
	Integer totalScore;

	// 及格分数
	Integer passScore;

	// 试卷说明
	String explain;

	// 创建时间
	Date createTime;

	public String getId() {
		return id;
	}

	public TestPaper setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public TestPaper setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public TestPaper setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return state;
	}

	public TestPaper setState(String state) {
		this.state = state;
		return this;
	}

	public Date getStartTime() {
		return startTime;
	}

	public TestPaper setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public TestPaper setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public Date getPublicTime() {
		return publicTime;
	}

	public TestPaper setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
		return this;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public TestPaper setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public TestPaper setPassScore(Integer passScore) {
		this.passScore = passScore;
		return this;
	}

	public String getExplain() {
		return explain;
	}

	public TestPaper setExplain(String explain) {
		this.explain = explain;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public TestPaper setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
