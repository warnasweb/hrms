package com.rey.rms.dao;

import java.util.List;

import com.rey.rms.hibernateBean.CandidateBean;
import com.rey.rms.hibernateBean.InterviewBean;

public interface InterviewDAO {
	List<InterviewBean> getInterviewList();

	InterviewBean getInterview(long id); 

	void saveInterview(InterviewBean interviewBean);

	void updateInterview(InterviewBean interviewBean);
}
