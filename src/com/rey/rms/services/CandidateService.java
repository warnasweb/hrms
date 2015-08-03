package com.rey.rms.services;

import java.util.List;

import com.rey.rms.hibernateBean.CandidateBean;

public interface CandidateService {
	List<CandidateBean> getCandidateList();

	CandidateBean getCandidate(long id);

	void saveCandidate(CandidateBean candidateBean);

	void updateCandidate(CandidateBean candidateBean);
}
