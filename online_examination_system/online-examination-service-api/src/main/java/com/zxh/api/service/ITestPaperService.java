package com.zxh.api.service;

import java.util.List;

import com.zxh.api.request.AddOrUpdateTestPaperRequest;
import com.zxh.api.request.DelTestPaperRequest;
import com.zxh.api.request.GetListBoxRequest;
import com.zxh.api.request.GetTestPaperRequest;
import com.zxh.api.request.ListTestPaperRequest;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.TestPaperAnalysisResponse;
import com.zxh.api.response.TestPaperDropDownResponse;
import com.zxh.api.response.TestPaperResponse;

/**
 * 试卷相关接口
 * 
 * @author ZXH
 */
public interface ITestPaperService {

	// 增加试卷
	void addTestPaper(AddOrUpdateTestPaperRequest request);

	// 更新试卷
	void updatTestPaper(AddOrUpdateTestPaperRequest request);

	// 删除试卷
	void delTestPaper(DelTestPaperRequest request);

	// 试卷列表
	ListResponse<List<TestPaperResponse>> list(ListTestPaperRequest request);

	// 试卷列表下拉框
	List<TestPaperDropDownResponse> listDropDownBox(GetListBoxRequest request);

	// 分析试卷结果
	TestPaperAnalysisResponse analysisPaper(GetTestPaperRequest request);
}
