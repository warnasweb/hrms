package com.rey.rms.services;

import java.util.List;

import com.rey.rms.hibernateBean.UserBean;
//import com.rey.rms.hibernateBean.UserRegistrationBean;

public interface LoginService {

	List<UserBean> getUserList();

	UserBean getUser(long id);

	void updateUser(UserBean userBean);

	void saveUser(UserBean userBean);
	
	UserBean  validateUser(UserBean loginBean);
}
