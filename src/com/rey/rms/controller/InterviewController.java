package com.rey.rms.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rey.rms.form.InterviewForm;
import com.rey.rms.form.RoundForm;
import com.rey.rms.hibernateBean.CandidateBean;
import com.rey.rms.hibernateBean.InterviewBean;
import com.rey.rms.hibernateBean.PanelBean;
import com.rey.rms.services.CandidateService;
import com.rey.rms.services.InterviewService;
import com.rey.rms.services.PanelService;
import com.rey.rms.util.Utility;

@Controller
@RequestMapping("/interviewController")
public class InterviewController {


	@Autowired
	CandidateService candidateService;
	

	@Autowired
	InterviewService interviewService;
	
	@Autowired
	PanelService panelService;
 
	@RequestMapping("/openInterview1.htm")
	public ModelAndView openNewCandidate() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("newInterview");
		return mv;
	}

	
	
	

	
	
	
	@RequestMapping("/openInterview.htm")
	public ModelAndView getCandidateList() {

		ModelAndView modelView = new ModelAndView();
		Map<Long, String> candidateMap = new LinkedHashMap<Long, String>();
		List<CandidateBean> lstvisitorBean = candidateService.getCandidateList();
		for(CandidateBean candidateBean: lstvisitorBean){
			candidateMap.put(candidateBean.getId(), candidateBean.getFirstName()+" "+candidateBean.getLastName());
		}
				
		modelView.addObject("candidateList", candidateMap);
		modelView.addObject("pgHead", "Manage Interviews");
		modelView.setViewName("newInterview");

		return modelView;

	}
	
	
	@RequestMapping("/viewCandidate.htm")
	public ModelAndView viewCandidate(@RequestParam("candidateID")String candidateID, @RequestParam("type")String type){
		ModelAndView modelView=new ModelAndView();
		modelView=viewCandidate(Long.parseLong(candidateID),type);

		return modelView;
		
	}
	
	public ModelAndView viewCandidate(Long candidateID,String type){
		InterviewForm interviewForm=null;
		ModelAndView modelView=new ModelAndView();
		if(candidateID!=null){
			CandidateBean candidateBean=candidateService.getCandidate(candidateID);
			interviewForm = new InterviewForm();
			interviewForm.setId(candidateBean.getId());
			interviewForm.setFirstName(candidateBean.getFirstName());
			interviewForm.setLastName(candidateBean.getLastName());
			interviewForm.setEmail(candidateBean.getEmail());
			interviewForm.setSkills(candidateBean.getSkills());
			interviewForm.setManager(candidateBean.getManager());
			interviewForm.setCurrentCTC(candidateBean.getCurrentCTC());
			interviewForm.setExpectedCTC(candidateBean.getExpectedCTC());
			interviewForm.setNoticePeriod(candidateBean.getNoticePeriod());
			interviewForm.setResult(candidateBean.getResult());
			if(candidateBean.getRounds().size()>0){
				for(InterviewBean interview:candidateBean.getRounds()){
					System.out.println(interview.getRound()+interview.getId());
				}
				interviewForm.setRounds(candidateBean.getRounds());
			}
		}
		
		modelView.addObject("candidate", interviewForm);
		if("view".equals(type)){
			modelView.setViewName("viewCandidate");
		}else if("details".equals(type)){
			modelView.setViewName("candidateDetails");
		}else{
			modelView.setViewName("updateCandidate");
		}

		return modelView;
		
	}
	
	
	
	
	@RequestMapping("/viewResume.htm")
	public String viewResume(@RequestParam("candidateID")String candidateID, HttpServletResponse response) {
		if(candidateID!=null){
		try {
			CandidateBean interviewBean=candidateService.getCandidate(Long.parseLong(candidateID));
		    response.setHeader("Content-Disposition", "attachment;filename=\"" +interviewBean.getFirstName()+ "_Resume.doc\"");
		    OutputStream out = response.getOutputStream();
		    response.setContentType("application/ms-word");
		    IOUtils.copy(interviewBean.getResume().getBinaryStream(), out);
		    out.flush();
		    out.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		}
 
	return null;
	}

	
		
		
	@RequestMapping(value="/updateInterview.htm", method=RequestMethod.POST)
	public ModelAndView updateInterview(@ModelAttribute("InterviewForm") InterviewForm interviewForm,
            @RequestParam("file") MultipartFile file){
		System.out.println(interviewForm.getFirstName()+interviewForm.getId());
		CandidateBean interviewBean = new CandidateBean();
		interviewBean.setId(interviewForm.getId());
		interviewBean.setFirstName(interviewForm.getFirstName());
		interviewBean.setLastName(interviewForm.getLastName());
		interviewBean.setEmail(interviewForm.getEmail());
		interviewBean.setSkills(interviewForm.getSkills());
		interviewBean.setManager(interviewForm.getManager());
		interviewBean.setCurrentCTC(interviewForm.getCurrentCTC());
		interviewBean.setExpectedCTC(interviewForm.getExpectedCTC());
		interviewBean.setNoticePeriod(interviewForm.getNoticePeriod());
//		interviewBean.setDateOfInterview(interviewForm.getDateOfInterview());
//		interviewBean.setStatus(interviewForm.getStatus());
//		interviewBean.setRound(interviewForm.getRound());
		interviewBean.setResult(interviewForm.getResult());
		try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            interviewBean.setResume(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		candidateService.updateCandidate(interviewBean);
		
		ModelAndView mv=getCandidateList();
		mv.addObject("message", "Record Updated SuccessFully");
		return mv;
	}
	
	@RequestMapping("/openNewRound.htm")
	public ModelAndView openNewRound() {//Keep this method

		ModelAndView modelView = new ModelAndView();
		List<PanelBean> panelList = panelService.getPanelList();
		Map<Long, String> panelMap = Utility.getPanels(panelList);
		modelView.addObject("panelMap", panelMap);
		modelView.setViewName("newRound");

		return modelView;

	}
	
	
	@RequestMapping(value="/saveNewRound.htm", method=RequestMethod.POST)
	public ModelAndView saveNewRound(@ModelAttribute("RoundForm") RoundForm roundForm){// Keep this method
		InterviewBean interviewBean = new InterviewBean();
		System.out.println(roundForm.getCandidateID());
		System.out.println(roundForm.getPanelID());
		interviewBean.setDateOfInterview(roundForm.getDateOfInterview());
		interviewBean.setRemarks(roundForm.getRemarks());
		interviewBean.setRound(roundForm.getRound());
		interviewBean.setResult(roundForm.getResult());
		interviewBean.setInterviewBean(candidateService.getCandidate(roundForm.getCandidateID()));
		interviewBean.setPanelBean(panelService.getPanel(roundForm.getPanelID()));
				
		System.out.println(roundForm.getPanelID());
		interviewService.saveInterview(interviewBean);
		
		ModelAndView mv=viewCandidate(roundForm.getCandidateID(),"details");
		mv.addObject("message", "Record Added SuccessFully");
		return mv;
	}

	
	
	@RequestMapping(value="/openUpdateRound.htm", method=RequestMethod.GET)
	public ModelAndView openUpdateRound(@RequestParam("roundID")Long roundID){
		InterviewBean interviewBean = new InterviewBean();
		System.out.println("roundID   "+roundID);
		RoundForm roundForm = new RoundForm();
		interviewBean=interviewService.getInterview(roundID);//Long.parseLong(roundID));
		roundForm.setRound(interviewBean.getRound());
		roundForm.setDoi(Utility.formatDate(interviewBean.getDateOfInterview()));
		roundForm.setId(interviewBean.getId());
		roundForm.setPanelID(interviewBean.getPanelBean().getId());
		roundForm.setRemarks(interviewBean.getRemarks());
		roundForm.setResult(interviewBean.getResult());
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("roundFrm", roundForm);
		Map<Long, String> panelMap = Utility.getPanels(panelService.getPanelList());
		modelView.addObject("panelMap", panelMap);
		modelView.setViewName("updateRound");
		modelView.addObject("message", "Record Added SuccessFully");
		return modelView;
	}
	
	
	@RequestMapping(value="/updateRound.htm", method=RequestMethod.POST)
	public ModelAndView updateRound(@ModelAttribute("RoundForm") RoundForm roundForm){
		InterviewBean interviewBean = new InterviewBean();
		System.out.println(roundForm.getCandidateID());
		System.out.println(roundForm.getPanelID());
		interviewBean.setId(roundForm.getId());
		interviewBean.setDateOfInterview(roundForm.getDateOfInterview());
		interviewBean.setRemarks(roundForm.getRemarks());
		interviewBean.setRound(roundForm.getRound());
		interviewBean.setResult(roundForm.getResult());
		interviewBean.setInterviewBean(candidateService.getCandidate(roundForm.getCandidateID()));
		interviewBean.setPanelBean(panelService.getPanel(roundForm.getPanelID()));
				
		System.out.println(roundForm.getPanelID());
		interviewService.updateInterview(interviewBean);
		
		ModelAndView mv=viewCandidate(roundForm.getCandidateID(),"details");
		mv.addObject("message", "Record Added SuccessFully");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/saveCandidate.htm", method=RequestMethod.POST)
	public ModelAndView saveCandidate(@ModelAttribute("InterviewForm") InterviewForm interviewForm,
            @RequestParam("file") MultipartFile file){
		System.out.println(interviewForm.getFirstName()+interviewForm.getId());
		CandidateBean interviewBean = new CandidateBean();
		interviewBean.setFirstName(interviewForm.getFirstName());
		interviewBean.setLastName(interviewForm.getLastName());
		interviewBean.setEmail(interviewForm.getEmail());
		interviewBean.setSkills(interviewForm.getSkills());
		interviewBean.setManager(interviewForm.getManager());
		interviewBean.setCurrentCTC(interviewForm.getCurrentCTC());
		interviewBean.setExpectedCTC(interviewForm.getExpectedCTC());
		interviewBean.setNoticePeriod(interviewForm.getNoticePeriod());
//		interviewBean.setDateOfInterview(interviewForm.getDateOfInterview());
//		interviewBean.setStatus(interviewForm.getStatus());
//		interviewBean.setRound(interviewForm.getRound());
		interviewBean.setResult(interviewForm.getResult());
		try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            interviewBean.setResume(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		candidateService.saveCandidate(interviewBean);
		
		ModelAndView mv=getCandidateList();
		mv.addObject("message", "Record Added SuccessFully");
		return mv;
	}


}
