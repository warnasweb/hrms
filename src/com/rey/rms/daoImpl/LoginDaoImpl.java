package com.rey.rms.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rey.rms.dao.LoginDao;
import com.rey.rms.hibernateBean.UserBean;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<UserBean> getUserList() {
		
		return (List<UserBean>) sessionFactory.openSession().createCriteria(UserBean.class).list();
	}
	
	
	public UserBean getUser(long id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			UserBean userBean = (UserBean) session.get(UserBean.class, id);
			return userBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void updateUser(UserBean userBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.update(userBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void saveUser(UserBean userBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(userBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	
	
	public UserBean validateUser(UserBean userBean) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(UserBean.class);
			criteria.add(Restrictions.eq("userName", userBean.getUserName()));
			criteria.add(Restrictions.eq("password", userBean.getPassword()));
			List<UserBean> lst = (List<UserBean> )criteria.list();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
