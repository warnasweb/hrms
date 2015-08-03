package com.rey.rms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rey.rms.dao.InterviewDAO;
import com.rey.rms.hibernateBean.InterviewBean;
import com.rey.rms.services.InterviewService;

@Service("interviewService")
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	InterviewDAO interviewDAO; 

	@Override
	public List<InterviewBean> getInterviewList() {
		// TODO Auto-generated method stub
		return interviewDAO.getInterviewList();
	}

	@Override
	public InterviewBean getInterview(long id){
		return interviewDAO.getInterview(id);
	}
	@Override
	public void saveInterview(InterviewBean panelBean) {
		// TODO Auto-generated method stub
		interviewDAO.saveInterview(panelBean);
	}

	@Override
	public void updateInterview(InterviewBean panelBean) {
		// TODO Auto-generated method stub
		interviewDAO.updateInterview(panelBean);		
	}
	
	

}
