package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ZXH 答案
 */
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	String id;

	// 题目主键
	Integer subjectId;

	// 选项
	String option;

	// 内容
	String content;

	// 是否正确答案
	Boolean flag;

	// 创建时间
	Date createTime;

	public String getId() {
		return id;
	}

	public Answer setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public Answer setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
		return this;
	}

	public String getOption() {
		return option;
	}

	public Answer setOption(String option) {
		this.option = option;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Answer setContent(String content) {
		this.content = content;
		return this;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public Answer setFlag(Boolean flag) {
		this.flag = flag;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Answer setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
