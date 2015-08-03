package com.rey.rms.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rey.rms.form.CandidateForm;
import com.rey.rms.hibernateBean.CandidateBean;
import com.rey.rms.services.CandidateService;

@Controller
@RequestMapping("/candidateController")
public class CandidateController {


	@Autowired
	CandidateService candidateService;

	@RequestMapping("/openNewCandidate.htm")
	public ModelAndView openNewCandidate() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("pgHead","Create Candidate Profile");
		mv.setViewName("newCandidate");
		return mv;
	}

	@RequestMapping("/openCandidateList.htm")
	public ModelAndView openCandidateList() {

		ModelAndView mv = new ModelAndView();
		List<CandidateForm> candidateList = new ArrayList<CandidateForm>();
		CandidateForm candidateForm = null;
		List<CandidateBean> candidateBeanList = candidateService.getCandidateList();
		for(CandidateBean candidateBean: candidateBeanList){
			candidateForm = new CandidateForm();
			candidateForm.setId(candidateBean.getId());
			candidateForm.setFirstName(candidateBean.getFirstName());
			candidateForm.setLastName(candidateBean.getLastName());
			candidateForm.setEmail(candidateBean.getEmail());
			candidateForm.setSkills(candidateBean.getSkills());
			candidateForm.setManager(candidateBean.getManager());
			candidateForm.setCurrentCTC(candidateBean.getCurrentCTC());
			candidateForm.setExpectedCTC(candidateBean.getExpectedCTC());
			candidateForm.setNoticePeriod(candidateBean.getNoticePeriod());
			candidateForm.setResult(candidateBean.getResult());;
			candidateList.add(candidateForm);
		}
		
		mv.addObject("col0", "S.No.");
		mv.addObject("col1", "Name");
		mv.addObject("col2", "Skills");
		mv.addObject("col3", "Result"); 
		mv.addObject("col4", "E-mail");
		mv.addObject("candidateList", candidateList);
		mv.addObject("reportTitle", "Manage Candidates");
		mv.setViewName("manageCandidates");

		return mv;

	}
	
	
	@RequestMapping("/viewCandidate.htm")
	public ModelAndView viewCandidate(@RequestParam("candidateID")Long candidateID, @RequestParam("type")String type){
		CandidateForm candidateForm=null;
		ModelAndView mv=new ModelAndView();
		if(candidateID!=null){
			CandidateBean candidateBean=candidateService.getCandidate(candidateID);
			candidateForm = new CandidateForm();
			candidateForm.setId(candidateBean.getId());
			candidateForm.setFirstName(candidateBean.getFirstName());
			candidateForm.setLastName(candidateBean.getLastName());
			candidateForm.setEmail(candidateBean.getEmail());
			candidateForm.setSkills(candidateBean.getSkills());
			candidateForm.setManager(candidateBean.getManager());
			candidateForm.setCurrentCTC(candidateBean.getCurrentCTC());
			candidateForm.setExpectedCTC(candidateBean.getExpectedCTC());
			candidateForm.setNoticePeriod(candidateBean.getNoticePeriod());
			candidateForm.setResult(candidateBean.getResult());
		}
		
		mv.addObject("candidate", candidateForm);
		if("view".equals(type)){
			mv.addObject("pgHead","View Candidate Profile");
			mv.setViewName("viewCandidate");
		}else{
			mv.addObject("pgHead","Update Candidate Profile");
			mv.setViewName("updateCandidate");
		}

		return mv;
		
	}
	
		
	@RequestMapping(value="/updateCandidate.htm", method=RequestMethod.POST)
	public String updateInterview(@ModelAttribute("CandidateForm") CandidateForm candidateForm,
            @RequestParam("file") MultipartFile file){
		System.out.println(candidateForm.getFirstName()+candidateForm.getId());
		CandidateBean candidateBean = new CandidateBean();
		candidateBean.setId(candidateForm.getId());
		candidateBean.setFirstName(candidateForm.getFirstName());
		candidateBean.setLastName(candidateForm.getLastName());
		candidateBean.setEmail(candidateForm.getEmail());
		candidateBean.setSkills(candidateForm.getSkills());
		candidateBean.setManager(candidateForm.getManager());
		candidateBean.setCurrentCTC(candidateForm.getCurrentCTC());
		candidateBean.setExpectedCTC(candidateForm.getExpectedCTC());
		candidateBean.setNoticePeriod(candidateForm.getNoticePeriod());
		candidateBean.setResult(candidateForm.getResult());
		try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            candidateBean.setResume(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		candidateService.updateCandidate(candidateBean);
		
		return "redirect:/candidateController/openCandidateList.htm";
	}
	
	@RequestMapping(value="/saveCandidate.htm", method=RequestMethod.POST)
	public String  saveCandidate(@ModelAttribute("CandidateForm") CandidateForm candidateForm,
            @RequestParam("file") MultipartFile file){//keep
		System.out.println(candidateForm.getFirstName()+candidateForm.getId());
		CandidateBean candudateBean = new CandidateBean();
		candudateBean.setFirstName(candidateForm.getFirstName());
		candudateBean.setLastName(candidateForm.getLastName());
		candudateBean.setEmail(candidateForm.getEmail());
		candudateBean.setSkills(candidateForm.getSkills());
		candudateBean.setManager(candidateForm.getManager());
		candudateBean.setCurrentCTC(candidateForm.getCurrentCTC());
		candudateBean.setExpectedCTC(candidateForm.getExpectedCTC());
		candudateBean.setNoticePeriod(candidateForm.getNoticePeriod());
		candudateBean.setResult(candidateForm.getResult());
		try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            candudateBean.setResume(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		candidateService.saveCandidate(candudateBean);
		
		//ModelAndView mv=openCandidateList();
		//mv.addObject("message", "Record Added SuccessFully");
		//return mv;
		return "redirect:/candidateController/openCandidateList.htm";
	}
	

}
