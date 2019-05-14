package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ZXH 题目
 */
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	// 题目解析
	String content;

	// 创建时间
	Date createTime;

	public Integer getId() {
		return id;
	}

	public Subject setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public Subject setType(String type) {
		this.type = type;
		return this;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public Subject setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getState() {
		return state;
	}

	public Subject setState(String state) {
		this.state = state;
		return this;
	}

	public String getStem() {
		return stem;
	}

	public Subject setStem(String stem) {
		this.stem = stem;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Subject setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Subject setContent(String content) {
		this.content = content;
		return this;
	}

}
