package com.rey.rms.hibernateBean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HR_INTERVIEWS")
public class InterviewBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "Round")
	private String round;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name="DateOfInterview")
	@Type(type="date")
	private Date dateOfInterview;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "Result")
	private String result;
	
	@ManyToOne
    @JoinColumn(name="candidate_id", 
                insertable=true, updatable=true, 
                nullable=false)
	private CandidateBean interviewBean;
	
	@OneToOne
    @JoinColumn(name="panel_id", 
                insertable=true, updatable=true, 
                nullable=false)
	private PanelBean panelBean;

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
	 * @return the interviewBean
	 */
	public CandidateBean getInterviewBean() {
		return interviewBean;
	}

	/**
	 * @param interviewBean the interviewBean to set
	 */
	public void setInterviewBean(CandidateBean interviewBean) {
		this.interviewBean = interviewBean;
	}

	/**
	 * @return the panelBean
	 */
	public PanelBean getPanelBean() {
		return panelBean;
	}

	/**
	 * @param panelBean the panelBean to set
	 */
	public void setPanelBean(PanelBean panelBean) {
		this.panelBean = panelBean;
	}
	
	
	
	
}
