package com.zxh.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.api.request.AddUserAnswerRequest;
import com.zxh.api.request.AnswerRequest;
import com.zxh.api.service.IUserPaperDetailService;
import com.zxh.dao.IAnswerDao;
import com.zxh.dao.IUserPaperDao;
import com.zxh.dao.IUserPaperDetailDao;
import com.zxh.entity.Answer;
import com.zxh.entity.UserPaper;
import com.zxh.entity.UserPaperDetail;

@Service
public class UserPaperDetailService implements IUserPaperDetailService {

	private static final Logger log = Logger.getLogger(UserPaperDetailService.class);

	@Autowired
	IUserPaperDetailDao userPaperDetailDao;

	@Autowired
	IUserPaperDao userPaperDao;

	@Autowired
	IAnswerDao answerDao;

	@Override
	public void addAnswer(AddUserAnswerRequest request) {
		log.info(String.format("student add answer"));

		List<AnswerRequest> list = request.getAnswers();
		for (AnswerRequest answerRequest : list) {
			Answer answer = answerDao.getByCorrect(answerRequest.getSubjectId(), answerRequest.getOption());
			userPaperDetailDao.insert(new UserPaperDetail().setAnswer(answerRequest.getOption())
					.setCreateTime(new Date()).setSubjectId(answerRequest.getSubjectId())
					.setUserPaperId(request.getUserPaperId()).setScore(answer == null ? 0 : 5));
		}
		
		Integer sum  = userPaperDetailDao.selectUserIdScore(request.getUserPaperId());
		UserPaper  userPaper = userPaperDao.get(request.getUserPaperId());
		userPaper.setActualScore(sum);
		userPaperDao.updateById(userPaper);
	}

}
