package com.zxh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxh.api.request.AddAnswerRequest;
import com.zxh.api.request.AddOrUpdateSubjectRequest;
import com.zxh.api.request.DelSubjectRequest;
import com.zxh.api.request.ListSubjectRequest;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.SubjectResponse;
import com.zxh.api.service.ISubjectService;
import com.zxh.dao.IAnswerDao;
import com.zxh.dao.ISubjectDao;
import com.zxh.entity.Answer;
import com.zxh.entity.Subject;

@Service
public class SubjectService implements ISubjectService {

	private static final Logger log = Logger.getLogger(SubjectService.class);

	@Autowired
	ISubjectDao subjectDao;

	@Autowired
	IAnswerDao answerDao;

	@Override
	public void addSubject(AddOrUpdateSubjectRequest request) {
		log.info(String.format("addSubject，request is %s", JSONObject.toJSONString(request)));
		Subject subject = new Subject().setContent(request.getContent()).setCreateTime(new Date())
				.setDifficulty(request.getDifficulty()).setState(request.getState()).setStem(request.getStem())
				.setType(request.getType());
		subjectDao.insert(subject);

		for (AddAnswerRequest addAnswerRequest : request.getAnswerList()) {
			answerDao.insert(new Answer().setContent(addAnswerRequest.getContent()).setCreateTime(new Date())
					.setFlag(addAnswerRequest.getFlag()).setOption(addAnswerRequest.getOption())
					.setSubjectId(subject.getId()));
		}

	}

	@Override
	public void updateSubject(AddOrUpdateSubjectRequest request) {
		log.info(String.format("updateSubject，request is %s", JSONObject.toJSONString(request)));
		Subject subject = subjectDao.get(request.getId());
		subject.setContent(request.getContent()).setDifficulty(request.getDifficulty()).setState(request.getState())
				.setStem(request.getStem()).setType(request.getType());
		subjectDao.updateById(subject);

		answerDao.deleteBySubjectId(subject.getId());
		for (AddAnswerRequest addAnswerRequest : request.getAnswerList()) {
			answerDao.insert(new Answer().setContent(addAnswerRequest.getContent()).setCreateTime(new Date())
					.setFlag(addAnswerRequest.getFlag()).setOption(addAnswerRequest.getOption())
					.setSubjectId(subject.getId()));
		}

	}

	@Override
	public ListResponse<List<SubjectResponse>> list(ListSubjectRequest request) {
		log.info(String.format("Subject list，request is %s", JSONObject.toJSONString(request)));
		PageInfo<Subject> info = PageHelper.startPage(request.getPageNum(), request.getPageSize())
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						subjectDao.selectByCondition(request.getType(), request.getDifficulty(), request.getState());
					}
				});
		List<Subject> list = info.getList();

		List<SubjectResponse> returnList = new ArrayList<>();
		for (Subject subject : list) {
			returnList.add(new SubjectResponse().setDifficulty(subject.getDifficulty()).setId(subject.getId())
					.setState(subject.getState()).setStem(subject.getStem()).setType(subject.getType()));
		}
		ListResponse<List<SubjectResponse>> response = new ListResponse<>();
		response.setData(returnList).setFirstPage(info.isIsFirstPage()).setHasNextPage(info.isHasNextPage())
				.setHasPreviousPage(info.isHasPreviousPage()).setLastPage(info.isIsLastPage());
		return response;
	}

	@Override
	public void delSubject(DelSubjectRequest request) {
		log.info(String.format("delSubject,request is %s", JSONObject.toJSONString(request)));
		subjectDao.deleteById(request.getId());
		answerDao.deleteBySubjectId(request.getId());
	}

	@Override
	public void addsubsubject(AddOrUpdateSubjectRequest request) {
		Subject subject = new Subject().setDifficulty(request.getAnswer()).setStem(request.getStem()).setType("主观题").setState("open");
		subjectDao.insert(subject);

	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return subjectDao.getSubject();
	}

}
