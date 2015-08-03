package com.rey.rms.dao;

import java.util.List;

import com.rey.rms.hibernateBean.CandidateBean;

public interface CandidateDAO {
	List<CandidateBean> getCandidateList();

	CandidateBean getCandidate(long id);

	void saveCandidate(CandidateBean interviewBean);

	void updateCandidate(CandidateBean interviewBean);
}
