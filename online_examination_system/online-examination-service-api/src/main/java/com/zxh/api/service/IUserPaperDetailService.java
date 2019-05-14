package com.zxh.api.service;

import com.zxh.api.request.AddUserAnswerRequest;

public interface IUserPaperDetailService {

	// 学生回答问题
	void addAnswer(AddUserAnswerRequest request);
}
