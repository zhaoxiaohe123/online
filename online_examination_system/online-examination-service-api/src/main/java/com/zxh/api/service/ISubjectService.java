package com.zxh.api.service;

import java.util.List;

import com.zxh.api.request.AddOrUpdateSubjectRequest;
import com.zxh.api.request.DelSubjectRequest;
import com.zxh.api.request.ListSubjectRequest;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.SubjectResponse;

/**
 * 题目相关接口
 * 
 * @author ZXH
 *
 */
public interface ISubjectService {

	// 增加题目
	void addSubject(AddOrUpdateSubjectRequest request);

	// 更新题目
	void updateSubject(AddOrUpdateSubjectRequest request);

	// 题目列表
	ListResponse<List<SubjectResponse>> list(ListSubjectRequest request);

	// 删除题目
	void delSubject(DelSubjectRequest request);

	void addsubsubject(AddOrUpdateSubjectRequest request);

	String getSubject();
}
