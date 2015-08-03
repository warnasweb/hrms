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

import com.rey.rms.form.UserForm;
import com.rey.rms.hibernateBean.UserBean;
import com.rey.rms.services.LoginService;

@Controller
@RequestMapping("/userController")
public class UserController {


	@Autowired
	LoginService userService;

	@RequestMapping("/newUser.htm")
	public ModelAndView newUser() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("pgHead", "Add New User");
		mv.addObject("frmType", "new");
		mv.setViewName("addUpdateUser");
		return mv;
	}

	@RequestMapping("/manageUsers.htm")
	public ModelAndView manageUsers() {

		ModelAndView modelView = new ModelAndView();
		List<UserForm> userList = new ArrayList<UserForm>();
		UserForm userForm = null;
		List<UserBean> panelBeanList = userService.getUserList();
		for(UserBean userBean: panelBeanList){
			userForm = new UserForm();
			userForm.setUserID(userBean.getUserId());
			userForm.setFirstName(userBean.getFirstName());
			userForm.setLastName(userBean.getLastName());
			userForm.setUserName(userBean.getUserName());
			userForm.setRole(userBean.getRole());
			userForm.setEmail(userBean.getEmail());
			userList.add(userForm);
		}
		
		modelView.addObject("col0", "S.No.");
		modelView.addObject("col1", "Name");
		modelView.addObject("col2", "Email");
		modelView.addObject("col3", "UserID");
		modelView.addObject("col3", "Role");
		modelView.addObject("lstReport", userList);
		modelView.addObject("reportTitle", "Manage Users");
		modelView.setViewName("manageUser");

		return modelView;

	}
	
	
	@RequestMapping("/openUpdateUser.htm")
	public ModelAndView openUpdateUser(@RequestParam("userID")Long userID){
		UserForm userForm=null;
		ModelAndView modelView=new ModelAndView();
		if(userID!=null){
			UserBean userBean=userService.getUser(userID);
			userForm = new UserForm();
			userForm.setUserID(userBean.getUserId());
			userForm.setFirstName(userBean.getFirstName());
			userForm.setLastName(userBean.getLastName());
			userForm.setRole(userBean.getRole());
			userForm.setUserName(userBean.getUserName());
			userForm.setEmail(userBean.getEmail());
			userForm.setPassword(userBean.getPassword());
		}
		
		modelView.addObject("user", userForm);
		modelView.addObject("message", "Record Updated SuccessFully");
		modelView.addObject("pgHead", "Update User");
		modelView.addObject("frmType", "edit");
		
		modelView.setViewName("addUpdateUser");

		return modelView;
		
	}
	
	
	
	@RequestMapping(value="/updateUser.htm", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("UserForm")UserForm userForm){
		System.out.println(userForm.getFirstName()+userForm.getUserID());
		UserBean userBean = new UserBean();
		userBean.setUserId(userForm.getUserID());
		userBean.setFirstName(userForm.getFirstName());
		userBean.setLastName(userForm.getLastName());
		userBean.setUserName(userForm.getUserName());
		userBean.setRole(userForm.getRole());
		userBean.setEmail(userForm.getEmail());
		userBean.setPassword(userForm.getPassword());
		userService.updateUser(userBean);
		
		ModelAndView mv=manageUsers();
		mv.setViewName("userList");
		mv.addObject("message", "Record Updated SuccessFully");
		return mv;
	}
	
	@RequestMapping(value="/saveUser.htm", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("UserForm")UserForm userForm){
		System.out.println(userForm.getFirstName()+userForm.getUserID());
		UserBean userBean = new UserBean();
		userBean.setUserId(userForm.getUserID());
		userBean.setFirstName(userForm.getFirstName());
		userBean.setLastName(userForm.getLastName());
		userBean.setRole(userForm.getRole());
		userBean.setEmail(userForm.getEmail());
		userBean.setUserName(userForm.getUserName());
		userBean.setPassword(userForm.getPassword());
		userService.saveUser(userBean);
		
		ModelAndView mv=manageUsers();
		mv.setViewName("userList");
		mv.addObject("message", "Record Updated SuccessFully");
		return mv;
	}
	

}
