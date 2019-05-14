package com.zxh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxh.api.request.AddUserAnswerRequest;
import com.zxh.api.request.GetTestPaperRequest;
import com.zxh.api.request.GetUserScoreRequest;
import com.zxh.api.request.UserPaperScore;
import com.zxh.api.response.TestPaperSubjectResponse;
import com.zxh.api.response.UserScoreResponse;
import com.zxh.api.service.IPaperSubjectService;
import com.zxh.api.service.ISubjectService;
import com.zxh.api.service.IUserPaperDetailService;
import com.zxh.api.service.IUserPaperService;
import com.zxh.entity.UserPaperDetail;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/userPaper/")
public class UserPaperController {

	@Autowired
	IPaperSubjectService paperSubjectService;

	@Autowired
	IUserPaperDetailService userPaperDetailService;
	
	
	@Autowired
	IUserPaperService userPaperService;
	
	@Autowired
	ISubjectService subjectService;

	// 查看试卷试题
	@ApiOperation(value = "查看试卷试题", notes = "查看试卷试题")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "试卷id", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "getPaper/v1", method = RequestMethod.POST)
	public List<TestPaperSubjectResponse> getTestPaper(@RequestBody GetTestPaperRequest request) {
		return paperSubjectService.getTestPaper(request);
	}

	// 回答试卷
	@ApiOperation(value = "回答试卷", notes = "回答试卷")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userPaperId", value = "用户考试id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "answers", value = "用户回答(看右边结构)", required = true, dataType = "List", paramType = "body") })
	@RequestMapping(value = "addAnswer/v1", method = RequestMethod.POST)
	public void addAnswer(@RequestBody AddUserAnswerRequest request) {
		userPaperDetailService.addAnswer(request);
	}
	
	
	//学生根据考试列表获取成绩
	@ApiOperation(value = "学生获取成绩", notes = "学生获取成绩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "paperId", value = "考试id", required = true, dataType = "String", paramType = "body")})
	@RequestMapping(value = "getScore/v1", method = RequestMethod.POST)
	public UserScoreResponse getScore(@RequestBody GetUserScoreRequest  request) {
		return userPaperService.getScore(request);
	}
	//学生获取成绩
	@ApiOperation(value = "学生获取成绩", notes = "学生获取成绩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "score", value = "用户id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "daan", value = "考试id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "id", value = "考试id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "userpaperid", value = "考试id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "userid", value = "考试id", required = true, dataType = "String", paramType = "body"),})
	@RequestMapping(value = "setScore/v1", method = RequestMethod.POST)
	public int setScore(@RequestBody UserPaperScore  request) {
		 userPaperService.setScore(request);
		 return 1;
	}
	
	//获取主观题
		@ApiOperation(value = "学生获取成绩", notes = "学生获取成绩")
		
		@RequestMapping(value = "getItemScore/v1", method = RequestMethod.POST)
		public UserPaperDetail getItemScore() {
			 
			  UserPaperDetail itemScore = userPaperService.getItemScore();
			  String sub = subjectService.getSubject();
			  itemScore.setZhuguanti(sub);
			  return itemScore;
		}
		
		//存入主观题分数
		@ApiOperation(value = "学生获取成绩", notes = "学生获取成绩")
		@ApiImplicitParams({
			@ApiImplicitParam(name = "score", value = "用户id", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "userid", value = "考试id", required = true, dataType = "String", paramType = "body"),})
		@RequestMapping(value = "getZHUGUANTIScore/v1", method = RequestMethod.POST)
		public int getZHUGUANTIScore(@RequestBody UserPaperScore  request) {
			 userPaperService.setZhuguanScore(request);
			 return 1;
		}

}
