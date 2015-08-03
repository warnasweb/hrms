package com.rey.rms.form;

import java.util.Date;

public class RoundForm {
	private long id;
	
	private long panelID;
	
	private long candidateID;
	
	private Date dateOfInterview;
	
	private String doi;
	private String status;
	
	private String round;
	
	private String remarks;
	
	private String panel;
	
	private String result;

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
	 * @return the panelID
	 */
	public long getPanelID() {
		return panelID;
	}

	/**
	 * @param panelID the panelID to set
	 */
	public void setPanelID(long panelID) {
		this.panelID = panelID;
	}

	/**
	 * @return the candidateID
	 */
	public long getCandidateID() {
		return candidateID;
	}

	/**
	 * @param candidateID the candidateID to set
	 */
	public void setCandidateID(long candidateID) {
		this.candidateID = candidateID;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	/**
	 * @return the doi
	 */
	public String getDoi() {
		return doi;
	}

	/**
	 * @param doi the doi to set
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}

}
