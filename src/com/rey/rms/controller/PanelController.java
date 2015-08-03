package com.rey.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rey.rms.form.PanelForm;
import com.rey.rms.hibernateBean.PanelBean;
import com.rey.rms.services.PanelService;

@Controller
@RequestMapping("/panelController")
public class PanelController {


	@Autowired
	PanelService panelService;

	@RequestMapping("/openNewPanel.htm")
	public ModelAndView openNewPanel() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("pgHead", "Add New Panel");
		mv.addObject("frmType", "new");
		mv.setViewName("addUpdatePanel");
		return mv;
	}

	@RequestMapping("/openPanel.htm")
	public ModelAndView openPanelList() {

		ModelAndView modelView = new ModelAndView();
		List<PanelForm> panelList = new ArrayList<PanelForm>();
		PanelForm panelForm = null;
		List<PanelBean> panelBeanList = panelService.getPanelList();
		for(PanelBean panelBean: panelBeanList){
			panelForm = new PanelForm();
			panelForm.setId(panelBean.getId());
			panelForm.setFirstName(panelBean.getFirstName());
			panelForm.setLastName(panelBean.getLastName());
			panelForm.setDesignation(panelBean.getDesignation());
			panelForm.setEmail(panelBean.getEmail());
			panelList.add(panelForm);
		}
		
		modelView.addObject("col0", "S.No.");
		modelView.addObject("col1", "Name");
		modelView.addObject("col2", "Email");
		modelView.addObject("col3", "Designation");
		modelView.addObject("lstReport", panelList);
		modelView.addObject("reportTitle", "Interview Panel");
		modelView.setViewName("managePanel");

		return modelView;

	}
	
	
	@RequestMapping("/openUpdatePanel.htm")
	public ModelAndView openUpdatePanel(@RequestParam("panelID")String panelID){
		PanelForm panelForm=null;
		ModelAndView mv=new ModelAndView();
		if(panelID!=null){
			PanelBean panelBean=panelService.getPanel(Long.parseLong(panelID));
			panelForm = new PanelForm();
			panelForm.setId(panelBean.getId());
			panelForm.setFirstName(panelBean.getFirstName());
			panelForm.setLastName(panelBean.getLastName());
			panelForm.setDesignation(panelBean.getDesignation());
			panelForm.setEmail(panelBean.getEmail());
		}
		
		mv.addObject("panel", panelForm);
		mv.addObject("message", "Record Updated SuccessFully");
		mv.addObject("pgHead", "Update Panel");
		mv.addObject("frmType", "edit");
		
		mv.setViewName("addUpdatePanel");
		//mv.setViewName("openUpdatePanel");

		return mv;
		
	}
	
	
	
	@RequestMapping(value="/updatePanel.htm", method=RequestMethod.POST)
	public ModelAndView updatePanel(@ModelAttribute("PanelForm")PanelForm panelForm){
		System.out.println(panelForm.getFirstName()+panelForm.getId());
		PanelBean panelBean = new PanelBean();
		panelBean.setId(panelForm.getId());
		panelBean.setFirstName(panelForm.getFirstName());
		panelBean.setLastName(panelForm.getLastName());
		panelBean.setDesignation(panelForm.getDesignation());
		panelBean.setEmail(panelForm.getEmail());
		panelService.updatePanel(panelBean);
		
		ModelAndView mv=openPanelList();
		mv.setViewName("panelList");
		mv.addObject("message", "Record Updated SuccessFully");
		return mv;
	}
	
	@RequestMapping(value="/savePanel.htm", method=RequestMethod.POST)
	public ModelAndView savePanel(@ModelAttribute("PanelForm")PanelForm panelForm){
		System.out.println("---------------------------------"+panelForm.getFirstName()+panelForm.getId());
		PanelBean panelBean = new PanelBean();
		panelBean.setId(panelForm.getId());
		panelBean.setFirstName(panelForm.getFirstName());
		panelBean.setLastName(panelForm.getLastName());
		panelBean.setDesignation(panelForm.getDesignation());
		panelBean.setEmail(panelForm.getEmail());
		panelService.savePanel(panelBean);
		
		ModelAndView mv=openPanelList();
		mv.setViewName("panelList");
		mv.addObject("message", "Record Updated SuccessFully");
		return mv;
	}
	

}