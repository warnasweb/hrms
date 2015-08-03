package com.rey.rms.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rey.rms.dao.InterviewDAO;
import com.rey.rms.hibernateBean.InterviewBean;

@Repository("interviewDAO")
public class InterviewDAOImpl implements InterviewDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<InterviewBean> getInterviewList() {
		
		Criteria cr =  sessionFactory.openSession().createCriteria(InterviewBean.class)
			    .setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("firstName"), "firstName")
			      .add(Projections.property("lastName"), "lastName"))
			    .setResultTransformer(Transformers.aliasToBean(InterviewBean.class));

			 // List<User> list = cr.list();
		
		return (List<InterviewBean>) cr.list();
	}
	
	
	public InterviewBean getInterview(long id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(InterviewBean.class);
			criteria.add(Restrictions.eq("id", id));
			List<InterviewBean> lst = (List<InterviewBean>)criteria.list();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public void saveInterview(InterviewBean interviewBean) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(interviewBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateInterview(InterviewBean interviewBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.update(interviewBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	

	

}
