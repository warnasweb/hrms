package com.rey.rms.form;

import java.util.Date;
import java.util.Set;

import com.rey.rms.hibernateBean.InterviewBean;


public class InterviewForm {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String skills;
		
	private String email;
	
	private String manager;
	
	private String currentCTC;
	
	private String expectedCTC;
	
	private String noticePeriod;
	
	private Date dateOfInterview;
	
	private String status;
	
	private String round;
	
	
	private String panel;
	
	private String result;
	
	private Set<InterviewBean> rounds;
	
	
	/**
	 * @return the rounds
	 */
	public Set<InterviewBean> getRounds() {
		return rounds;
	}

	/**
	 * @param rounds the rounds to set
	 */
	public void setRounds(Set<InterviewBean> rounds) {
		this.rounds = rounds;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * @return the currentCTC
	 */
	public String getCurrentCTC() {
		return currentCTC;
	}

	/**
	 * @param currentCTC the currentCTC to set
	 */
	public void setCurrentCTC(String currentCTC) {
		this.currentCTC = currentCTC;
	}

	/**
	 * @return the expectedCTC
	 */
	public String getExpectedCTC() {
		return expectedCTC;
	}

	/**
	 * @param expectedCTC the expectedCTC to set
	 */
	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	/**
	 * @return the noticePeriod
	 */
	public String getNoticePeriod() {
		return noticePeriod;
	}

	/**
	 * @param noticePeriod the noticePeriod to set
	 */
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	/**
	 * @return the dateOfInterview
	 */
	public Date getDateOfInterview() {
		return dateOfInterview;
	}

	/**
	 * @param dateOfInterview the dateOfInterview to set
	 */
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the round
	 */
	public String getRound() {
		return round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(String round) {
		this.round = round;
	}


	/**
	 * @return the panel
	 */
	public String getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(String panel) {
		this.panel = panel;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}
