package com.zxh.api.response;

import java.util.List;

import com.zxh.response.PaperAnswerResponse;
import com.zxh.response.PaperSubjectResponse;

public class TestPaperSubjectResponse {
	
	//试卷id
	String paperId;

	//题目
	PaperSubjectResponse sResponse;

	//回答
	List<PaperAnswerResponse> aResponse;
	
	

	public String getPaperId() {
		return paperId;
	}

	public TestPaperSubjectResponse setPaperId(String paperId) {
		this.paperId = paperId;
		return this;
	}

	public PaperSubjectResponse getsResponse() {
		return sResponse;
	}

	public TestPaperSubjectResponse setsResponse(PaperSubjectResponse sResponse) {
		this.sResponse = sResponse;
		return this;
	}

	public List<PaperAnswerResponse> getaResponse() {
		return aResponse;
	}

	public TestPaperSubjectResponse setaResponse(List<PaperAnswerResponse> aResponse) {
		this.aResponse = aResponse;
		return this;
	}

}
