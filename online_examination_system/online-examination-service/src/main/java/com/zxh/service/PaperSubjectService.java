package com.zxh.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zxh.api.request.GetTestPaperRequest;
import com.zxh.api.response.TestPaperSubjectResponse;
import com.zxh.api.service.IPaperSubjectService;
import com.zxh.dao.IAnswerDao;
import com.zxh.dao.IPaperSubjectDao;
import com.zxh.dao.ISubjectDao;
import com.zxh.entity.PaperSubject;
import com.zxh.response.PaperAnswerResponse;
import com.zxh.response.PaperSubjectResponse;

@Service
public class PaperSubjectService implements IPaperSubjectService {

	private static final Logger log = Logger.getLogger(PaperSubjectService.class);

	@Autowired
	IPaperSubjectDao paperSubjectDao;

	@Autowired
	ISubjectDao subjectDao;

	@Autowired
	IAnswerDao answerDao;

	@Override
	public List<TestPaperSubjectResponse> getTestPaper(GetTestPaperRequest request) {
		log.info(String.format("getTestPaper,request is %s", JSONObject.toJSONString(request)));
		List<TestPaperSubjectResponse> response = new ArrayList<>();
		List<PaperSubject> list = paperSubjectDao.selectByCondition(request.getId());

		PaperSubjectResponse sResp = null;
		List<PaperAnswerResponse> aRes = null;
		for (PaperSubject paperSubject : list) {
			sResp = subjectDao.getByPaper(paperSubject.getSubjectId());
			aRes = answerDao.listByPaperId(paperSubject.getSubjectId());
			response.add(
					new TestPaperSubjectResponse().setaResponse(aRes).setsResponse(sResp).setPaperId(request.getId()));
		}
		return response;
	}

}
