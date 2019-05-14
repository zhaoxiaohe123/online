package com.zxh.api.service;

import java.util.List;

import com.zxh.api.request.GetTestPaperRequest;
import com.zxh.api.response.TestPaperSubjectResponse;

public interface IPaperSubjectService {

	// 查看试卷试题
	List<TestPaperSubjectResponse> getTestPaper(GetTestPaperRequest request);
}
