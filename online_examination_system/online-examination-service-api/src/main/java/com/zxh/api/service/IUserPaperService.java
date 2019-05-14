package com.zxh.api.service;

import java.util.List;

import com.zxh.api.request.GetUserScoreRequest;
import com.zxh.api.request.ListUserPaperRequest;
import com.zxh.api.request.UserPaperScore;
import com.zxh.api.response.ListResponse;
import com.zxh.api.response.UserScoreResponse;
import com.zxh.entity.UserPaper;
import com.zxh.entity.UserPaperDetail;

public interface IUserPaperService {

	// 查询个人的参与考试情况 
	ListResponse<List<UserPaper>> list(ListUserPaperRequest request);

	//根据考试列表获取成绩
	UserScoreResponse getScore(GetUserScoreRequest request);

	void setScore(UserPaperScore request);

	UserPaperDetail getItemScore();

	void setZhuguanScore(UserPaperScore request);

}
