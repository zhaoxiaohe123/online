package com.zxh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxh.annotation.Asyn;
import com.zxh.api.constant.OpenState;
import com.zxh.api.constant.UserRole;
import com.zxh.api.exception.TestPaperException;
import com.zxh.api.exception.UserException;
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
import com.zxh.dao.IPaperSubjectDao;
import com.zxh.dao.ISubjectDao;
import com.zxh.dao.ITestPaperDao;
import com.zxh.dao.IUserDao;
import com.zxh.dao.IUserPaperDao;
import com.zxh.entity.PaperSubject;
import com.zxh.entity.Subject;
import com.zxh.entity.TestPaper;
import com.zxh.entity.User;
import com.zxh.entity.UserPaper;
import com.zxh.response.ScoreResponse;

@Service
public class TestPaperService implements ITestPaperService {

	private static final Logger log = Logger.getLogger(TestPaperService.class);

	@Autowired
	ISubjectDao subjectDao;

	@Autowired
	IPaperSubjectDao paperSubjectDao;

	@Autowired
	ITestPaperDao paperDao;

	@Autowired
	IUserDao userDao;

	@Autowired
	IUserPaperDao userPaperDao;

	@Override
	@Asyn(value = "'testPaper'")
	public void addTestPaper(AddOrUpdateTestPaperRequest request) {
		log.info(String.format("addTestPaper,request is %s", JSONObject.toJSONString(request)));
		// 应出题数
		Integer count = request.getTotalScore() / 10;
		// 存在题数
		Integer sumCount = subjectDao.selectCount(OpenState.OPEN);

		List<User> userList = userDao.selectByCondition(UserRole.STUDENT);

		if (userList == null || (userList != null && userList.size() < 0)) {
			throw new UserException("当前系统中无学生角色，不可以创建空白试卷");
		}

		if (sumCount < count) {
			throw new TestPaperException("当前题库数量不足，不能创建试卷");
		} else if (sumCount == count) {
			TestPaper testPaper = new TestPaper().setCreateTime(new Date()).setEndTime(new Date(request.getEndTime()))
					.setExplain(request.getExplain()).setName(request.getName()).setPassScore(request.getPassScore())
					.setPublicTime(new Date(request.getPublicTime())).setStartTime(new Date(request.getStartTime()))
					.setState(request.getState()).setTotalScore(request.getTotalScore()).setType(request.getType());
			paperDao.insert(testPaper);

			for (User user : userList) {
				userPaperDao.insert(new UserPaper().setCreateTime(new Date()).setEndTime(testPaper.getEndTime())
						.setName(testPaper.getName()).setPaperId(testPaper.getId())
						.setStartTime(testPaper.getStartTime()).setTotalScore(testPaper.getTotalScore())
						.setType(testPaper.getType()).setUserId(user.getId()));
			}
			// 查询当前题库
			List<Subject> list = subjectDao.selectByCondition(null, null, OpenState.OPEN);
			for (Subject subject : list) {
				paperSubjectDao.insert(new PaperSubject().setPaperId(testPaper.getId()).setSubjectId(subject.getId())
						.setCreateTime(new Date()));
			}
		} else {
			PageInfo<Subject> info = PageHelper.startPage(1, count).doSelectPageInfo(new ISelect() {
				@Override
				public void doSelect() {
					subjectDao.selectByRandom();
				}
			});
			List<Subject> list = info.getList();

			TestPaper testPaper = new TestPaper().setCreateTime(new Date()).setEndTime(new Date(request.getEndTime()))
					.setExplain(request.getExplain()).setName(request.getName()).setPassScore(request.getPassScore())
					.setPublicTime(new Date(request.getPublicTime())).setStartTime(new Date(request.getStartTime()))
					.setState(request.getState()).setTotalScore(request.getTotalScore()).setType(request.getType());
			paperDao.insert(testPaper);

			for (User user : userList) {
				userPaperDao.insert(new UserPaper().setCreateTime(new Date()).setEndTime(testPaper.getEndTime())
						.setName(testPaper.getName()).setPaperId(testPaper.getId())
						.setStartTime(testPaper.getStartTime()).setTotalScore(testPaper.getTotalScore())
						.setType(testPaper.getType()).setUserId(user.getId()));
			}

			for (Subject subject : list) {
				paperSubjectDao.insert(new PaperSubject().setPaperId(testPaper.getId()).setSubjectId(subject.getId())
						.setCreateTime(new Date()));
			}

		}

	}

	@Override
	public void updatTestPaper(AddOrUpdateTestPaperRequest request) {
		log.info(String.format("updatTestPaper,request is %s", JSONObject.toJSONString(request)));
		TestPaper testPaper = paperDao.get(request.getId());
		if (testPaper.getStartTime().getTime() < new Date().getTime()) {
			throw new TestPaperException("500","考试时间已经开始，不能进行修改");
		}
		testPaper.setEndTime(new Date(request.getEndTime())).setExplain(request.getExplain()).setName(request.getName())
				.setPublicTime(new Date(request.getPublicTime())).setStartTime(new Date(request.getStartTime()))
				.setState(request.getState()).setType(request.getType());
		paperDao.updateById(testPaper);
	}

	@Override
	public void delTestPaper(DelTestPaperRequest request) {
		log.info(String.format("delTestPaper,request is %s", JSONObject.toJSONString(request)));
		paperDao.deleteById(request.getId());
		paperSubjectDao.deleteByPaperId(request.getId());
		userPaperDao.deleteByPaperId(request.getId());
	}

	@Override
	public ListResponse<List<TestPaperResponse>> list(ListTestPaperRequest request) {
		log.info(String.format("TestPaperResponse list,request is %s", JSONObject.toJSONString(request)));

		ListResponse<List<TestPaperResponse>> response = new ListResponse<List<TestPaperResponse>>();
		PageInfo<TestPaper> info = PageHelper.startPage(request.getPageNum(), request.getPageSize())
				.doSelectPageInfo(new ISelect() {

					@Override
					public void doSelect() {
						paperDao.selectByCondition(request.getName(), request.getState(), request.getType());
					}
				});

		List<TestPaperResponse> returnList = new ArrayList<>();
		for (TestPaper testPaper : info.getList()) {
			returnList.add(new TestPaperResponse().setEndTime(testPaper.getEndTime()).setId(testPaper.getId())
					.setName(testPaper.getName()).setStartTime(testPaper.getStartTime()).setState(testPaper.getState())
					.setTotalScore(testPaper.getTotalScore()).setType(testPaper.getType()));
		}
		response.setData(returnList).setFirstPage(info.isIsFirstPage()).setHasNextPage(info.isHasNextPage())
				.setHasPreviousPage(info.isHasPreviousPage()).setLastPage(info.isIsLastPage());
		return response;
	}

	@Override
	public List<TestPaperDropDownResponse> listDropDownBox(GetListBoxRequest request) {
		log.info(String.format("listDropDownBox"));
		List<TestPaperDropDownResponse> returnList = new ArrayList<>();

		if (StringUtils.isBlank(request.getUserId())) {
			List<TestPaper> list = paperDao.selectByCondition(null, OpenState.OPEN, null);
			for (TestPaper testPaper : list) {
				returnList.add(new TestPaperDropDownResponse().setId(testPaper.getId()).setName(testPaper.getName()));
			}
		} else {
			List<TestPaper> list = paperDao.selectByUser(request.getUserId());
			for (TestPaper testPaper : list) {
				returnList.add(new TestPaperDropDownResponse().setId(testPaper.getId()).setName(testPaper.getName()));
			}
		}
		return returnList;
	}

	@Override
	public TestPaperAnalysisResponse analysisPaper(GetTestPaperRequest request) {
		log.info(String.format("analysisPaper，request is %s", JSONObject.toJSONString(request)));
		ScoreResponse resp = userPaperDao.selectByPaperId(request.getId());
		Integer passScore = paperDao.get(request.getId()).getPassScore();//空指针异常
		Integer totalCount = userPaperDao.selectByCount(request.getId(), null);
		Integer passCount = userPaperDao.selectByCount(request.getId(), passScore);
		return new TestPaperAnalysisResponse().setAverage(resp.getAvgScore()).setMaxScore(resp.getMaxScore())
				.setMinScore(resp.getMinScore()).setTotalPerson(totalCount).setPassPerson(passCount);
	}

}
