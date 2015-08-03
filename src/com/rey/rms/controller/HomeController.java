package com.rey.rms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rey.rms.form.LoginForm;
import com.rey.rms.hibernateBean.UserBean;
import com.rey.rms.services.LoginService;

@SessionAttributes({ "userId","usrName" })
@Controller
@RequestMapping("/homeController")
public class HomeController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/loginProcess.htm", method = RequestMethod.POST)
	public ModelAndView loginProcess(
			@ModelAttribute("loginBean") LoginForm loginForm) {

		System.out.println("UserId : " + loginForm.getUserId());
		ModelAndView mv = new ModelAndView();
		UserBean userBean = new UserBean();
		userBean.setPassword(loginForm.getPassword());
		userBean.setUserName(loginForm.getUserId());
		UserBean user =loginService.validateUser(userBean);
		if (user!=null) {
			mv.setViewName("home");
			mv.addObject("userId", loginForm.getUserId());
			mv.addObject("usrName", user.getFirstName()+" "+user.getLastName());
		} else {
			mv.addObject("message", "Invalid login detail.");
			mv.setViewName("login");
		}
		
		return mv;
	}

	@RequestMapping(value = "/home.htm")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value = "/logout.htm")
	public ModelAndView logOut(HttpSession session) {
		if (session != null) {
			session.invalidate();
			session = null;
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout", "logout");
		mv.addObject("message", "You have successfully logged out.");
		mv.setViewName("login");
		return mv;

	}

}
