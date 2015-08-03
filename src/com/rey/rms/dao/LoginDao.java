package com.rey.rms.dao;

import java.util.List;

import com.rey.rms.hibernateBean.UserBean;

public interface LoginDao {

	public List<UserBean> getUserList();

	public UserBean getUser(long id);

	public void updateUser(UserBean userBean);

	public void saveUser(UserBean userBean);

	public UserBean validateUser(UserBean userBean);
}
