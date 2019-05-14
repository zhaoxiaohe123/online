package com.zxh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxh.api.request.AddOrUpdateTestPaperRequest;
import com.zxh.api.request.DelTestPaperRequest;
import com.zxh.api.request.GetListBoxRequest;
import com.zxh.api.request.GetTestPaperRequest;
import com.zxh.api.request.ListTestPaperRequest;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.TestPaperAnalysisResponse;
import com.zxh.api.response.TestPaperDropDownResponse;
import com.zxh.api.response.TestPaperResponse;
import com.zxh.api.service.ITestPaperService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/testPaper/")
public class TestPaperController {

	@Autowired
	ITestPaperService testPaperService;

	// 新增试卷
	@ApiOperation(value = "新增试卷", notes = "新增试卷")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "type", value = "试卷类型", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "考试状态", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "startTime", value = "开考时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "endTime", value = "结束时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "publicTime", value = "公布时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "totalScore", value = "卷面总分", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "passScore", value = "及格分数", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "explain", value = "试卷说明", required = false, dataType = "int", paramType = "body")})
	@RequestMapping(value = "add/v1", method = RequestMethod.POST)
	public void addTestPaper(@RequestBody AddOrUpdateTestPaperRequest request) {
		testPaperService.addTestPaper(request);
	}

	// 更新试卷
	@ApiOperation(value = "更新试卷", notes = "更新试卷")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "type", value = "试卷类型", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "考试状态", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "startTime", value = "开考时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "endTime", value = "结束时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "publicTime", value = "公布时间(毫秒级别)", required = true, dataType = "Long", paramType = "body"),
			@ApiImplicitParam(name = "totalScore", value = "卷面总分", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "passScore", value = "及格分数", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "explain", value = "试卷说明", required = true, dataType = "int", paramType = "body")})
	@RequestMapping(value = "update/v1", method = RequestMethod.POST)
	public void updatTestPaper(@RequestBody AddOrUpdateTestPaperRequest request) {
		testPaperService.updatTestPaper(request);
	}

	// 删除试卷
	@ApiOperation(value = "删除试卷", notes = "删除试卷")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "body")})
	@RequestMapping(value = "del/v1", method = RequestMethod.POST)
	public void delTestPaper(@RequestBody DelTestPaperRequest request) {
		testPaperService.delTestPaper(request);
	}

	// 试卷列表
	@ApiOperation(value = "试卷列表--教师端", notes = "试卷列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "状态", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "type", value = "类型", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "body")})
	@RequestMapping(value = "list/v1", method = RequestMethod.POST)
	public ListResponse<List<TestPaperResponse>> list(@RequestBody ListTestPaperRequest request) {
		return testPaperService.list(request);
	}

	// 试卷列表下拉框
	@ApiOperation(value = "试卷列表下拉框", notes = "试卷列表下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "学生端传递学生id（教师端不需要传递）", required = true, dataType = "String", paramType = "body")})
	@RequestMapping(value = "listBox/v1", method = RequestMethod.POST)
	public List<TestPaperDropDownResponse> dropDownBox(@RequestBody GetListBoxRequest request) {
		return testPaperService.listDropDownBox(request);
	}

	//试卷分析
	@ApiOperation(value = "试卷分析", notes = "试卷分析")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "试卷id(教师端)", required = true, dataType = "String", paramType = "body")})
	@RequestMapping(value = "analysis/v1", method = RequestMethod.POST)
	public TestPaperAnalysisResponse analysisPaper(@RequestBody GetTestPaperRequest request) {
		return testPaperService.analysisPaper(request);
	}
}
