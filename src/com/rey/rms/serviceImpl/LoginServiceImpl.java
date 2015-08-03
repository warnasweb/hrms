package com.rey.rms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rey.rms.dao.LoginDao;
import com.rey.rms.hibernateBean.UserBean;
import com.rey.rms.services.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDAO;
	
/*	public boolean validateUser(UserRegistrationBean userBean) {
		
		return loginDao.validateUser(userBean);
	}*/
	
	public UserBean validateUser(UserBean userBean) {
		
		return loginDAO.validateUser(userBean);
	}

	@Override
	public List<UserBean> getUserList() {
		// TODO Auto-generated method stub
		return loginDAO.getUserList();
	}

	@Override
	public UserBean getUser(long id) {
		// TODO Auto-generated method stub
		return loginDAO.getUser(id);
	}

	@Override
	public void updateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		loginDAO.updateUser(userBean);
	}

	@Override
	public void saveUser(UserBean userBean) {
		// TODO Auto-generated method stub
		loginDAO.saveUser(userBean);
	}

	
}
