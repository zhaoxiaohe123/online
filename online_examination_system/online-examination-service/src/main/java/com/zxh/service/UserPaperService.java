package com.zxh.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxh.api.exception.TestPaperException;
import com.zxh.api.request.GetUserScoreRequest;
import com.zxh.api.request.ListUserPaperRequest;
import com.zxh.api.request.UserPaperScore;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.UserScoreResponse;
import com.zxh.api.service.IUserPaperService;
import com.zxh.dao.ITestPaperDao;
import com.zxh.dao.IUserPaperDao;
import com.zxh.dao.IUserPaperDetailDao;
import com.zxh.entity.UserPaper;
import com.zxh.entity.UserPaperDetail;

@Service
public class UserPaperService implements IUserPaperService {

	private static final Logger log = Logger.getLogger(UserPaperService.class);

	@Autowired
	IUserPaperDao userPaperDao;

	@Autowired
	ITestPaperDao testPaperDao;
	
	@Autowired
	IUserPaperDetailDao userPaperDetailDao;

	@Override
	public ListResponse<List<UserPaper>> list(ListUserPaperRequest request) {
		log.info(String.format("list,request is %s", JSONObject.toJSONString(request)));

		PageInfo<UserPaper> info = PageHelper.startPage(request.getPageNum(), request.getPageSize())
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						userPaperDao.selectByCondition(null, request.getName(), request.getType(), request.getUserId());
					}
				});
		ListResponse<List<UserPaper>> response = new ListResponse<List<UserPaper>>();
		response.setData(info.getList()).setFirstPage(info.isIsFirstPage()).setHasNextPage(info.isHasNextPage())
				.setHasPreviousPage(info.isHasPreviousPage()).setLastPage(info.isIsLastPage());
		return response;
	}

	@Override
	public UserScoreResponse getScore(GetUserScoreRequest request) {
		log.info(String.format("getScore,request is %s", JSONObject.toJSONString(request)));
		Date publicTime = testPaperDao.get(request.getPaperId()).getPublicTime();

//		if (publicTime != null && publicTime.getTime() > new Date().getTime()) {
//			throw new TestPaperException("当前考试还未到公布考试时间，请耐心等待");
//		}
		List<UserPaper> list = userPaperDao.selectByCondition(request.getPaperId(), null, null, request.getUserId());
		return new UserScoreResponse().setScore(list.get(0).getActualScore());
	}

	@Override
	public void setScore(UserPaperScore request) {
		// TODO Auto-generated method stub
		UserPaperDetail userPaperDetail = new UserPaperDetail();
		userPaperDetail.setUserPaperId(request.getId()).setScore(Integer.parseInt(request.getScore())).
		setAnswer(request.getDaan()).setSubjectId(Integer.parseInt(request.getUserid()));
		userPaperDetailDao.insert(userPaperDetail);
	}

	@Override
	public UserPaperDetail getItemScore() {
		// TODO Auto-generated method stub
		return userPaperDetailDao.getAll();
	}

	@Override
	public void setZhuguanScore(UserPaperScore request) {
		UserPaperDetail userPaperDetail = new UserPaperDetail();
		UserPaperDetail userPaperDetail2 = userPaperDetailDao.get(request.getId());
		userPaperDetail.setId(request.getId()).setScore(userPaperDetail2.getScore()+Integer.parseInt(request.getScore()));
		// TODO Auto-generated method stub
		userPaperDetailDao.updatescore(userPaperDetail);
		List<UserPaper> list = userPaperDao.selectByCondition(request.getUserpaperid(), null, null, request.getUserid());
		UserPaper userPaper = list.get(0);
		userPaper.setActualScore(userPaperDetail2.getScore()+Integer.parseInt(request.getScore()));
		userPaperDao.updateById(userPaper);
	}

}
