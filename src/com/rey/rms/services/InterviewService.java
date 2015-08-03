package com.rey.rms.services;

import java.util.List;

import com.rey.rms.hibernateBean.InterviewBean;

public interface InterviewService {
	List<InterviewBean> getInterviewList();

	InterviewBean getInterview(long id);

	void saveInterview(InterviewBean interviewBean);

	void updateInterview(InterviewBean interviewBean);
}
