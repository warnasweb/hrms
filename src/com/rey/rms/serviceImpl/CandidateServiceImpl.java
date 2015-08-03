package com.rey.rms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rey.rms.dao.CandidateDAO;
import com.rey.rms.hibernateBean.CandidateBean;
import com.rey.rms.services.CandidateService;

@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateDAO candidateDAO;

	@Override
	public List<CandidateBean> getCandidateList() {
		// TODO Auto-generated method stub
		return candidateDAO.getCandidateList();
	}

	@Override
	public CandidateBean getCandidate(long id){
		return candidateDAO.getCandidate(id);
	}
	@Override
	public void saveCandidate(CandidateBean candidateBean) {
		// TODO Auto-generated method stub
		candidateDAO.saveCandidate(candidateBean);
	}

	@Override
	public void updateCandidate(CandidateBean candidateBean) {
		// TODO Auto-generated method stub
		candidateDAO.updateCandidate(candidateBean);		
	}
	
	

}
