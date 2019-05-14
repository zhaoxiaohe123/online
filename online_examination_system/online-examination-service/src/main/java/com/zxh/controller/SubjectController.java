package com.zxh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zxh.api.request.AddOrUpdateSubjectRequest;
import com.zxh.api.request.DelSubjectRequest;
import com.zxh.api.request.ListSubjectRequest;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.SubjectResponse;
import com.zxh.api.service.ISubjectService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/subject/")
public class SubjectController {

	@Autowired
	ISubjectService subjectService;

	/**
	 * 增加试题
	 * 
	 * @param request
	 */
	@ApiOperation(value = "增加试题", notes = "增加试题")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "试题类型", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "difficulty", value = "试题难度", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "所属状态", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "stem", value = "题干", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "content", value = "题目解析", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "answerList", value = "答案列表（看右侧结构）", required = true, dataType = "List", paramType = "body") })
	@RequestMapping(value = "add/v1", method = RequestMethod.POST)
	public void addSubject(@RequestBody AddOrUpdateSubjectRequest request) {
		subjectService.addSubject(request);
	}

		/**
	 * 增加主觀題
	 * 
	 * 
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "answer", value = "题目解析", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "stem", value = "答案列表（看右侧结构）", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "addSub/v1", method = RequestMethod.POST)
	public int addSubSubject(@RequestBody AddOrUpdateSubjectRequest request) {
		System.out.println(request.getAnswer()+"!!!!!!!!!!!!!!!!!"+request.getStem());
		subjectService.addsubsubject(request);
		return 1;
	}

	/**
	 * 更新试题
	 * 
	 * @param request
	 */
	@ApiOperation(value = "更新试题", notes = "更新试题")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "试题id", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "type", value = "试题类型", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "difficulty", value = "试题难度", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "所属状态", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "stem", value = "题干", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "content", value = "题目解析", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "answerList", value = "答案列表（看右侧结构）", required = true, dataType = "List", paramType = "body") })
	@RequestMapping(value = "update/v1", method = RequestMethod.POST)
	public void updateSubject(@RequestBody AddOrUpdateSubjectRequest request) {
		subjectService.updateSubject(request);
	}

	/**
	 * 删除试题
	 * 
	 * @param request
	 */
	@ApiOperation(value = "删除试题", notes = "删除试题")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "试题id", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "del/v1", method = RequestMethod.POST)
	public void delSubject(@RequestBody DelSubjectRequest request) {
		subjectService.delSubject(request);
	}

	/**
	 * 试题列表
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "试题列表", notes = "试题列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "试题类型", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "difficulty", value = "试题难度", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "state", value = "所属状态", required = false, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "body") })
	@RequestMapping(value = "list/v1", method = RequestMethod.POST)
	public ListResponse<List<SubjectResponse>> list(@RequestBody ListSubjectRequest request) {
		return subjectService.list(request);
	}

}
