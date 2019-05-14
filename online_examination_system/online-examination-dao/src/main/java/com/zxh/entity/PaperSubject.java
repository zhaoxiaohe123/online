package com.zxh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ZXH 试卷题目
 */
public class PaperSubject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;

	// 试卷id
	String paperId;

	// 题目id
	Integer subjectId;
	
	//创建时间
	Date createTime;
	
	

	public Date getCreateTime() {
		return createTime;
	}

	public PaperSubject setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getId() {
		return id;
	}

	public PaperSubject setId(String id) {
		this.id = id;
		return this;
	}

	public String getPaperId() {
		return paperId;
	}

	public PaperSubject setPaperId(String paperId) {
		this.paperId = paperId;
		return this;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public PaperSubject setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
		return this;
	}

}
