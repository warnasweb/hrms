package com.rey.rms.daoImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rey.rms.dao.CandidateDAO;
import com.rey.rms.hibernateBean.CandidateBean;

@Repository("candidateDAO")
public class CandidateDAOImpl implements CandidateDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<CandidateBean> getCandidateList() {
		
		return (List<CandidateBean>) sessionFactory.openSession().createCriteria(CandidateBean.class).list();
	}
	
	
	public CandidateBean getCandidate(long id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(CandidateBean.class);
			criteria.add(Restrictions.eq("id", id));
			List<CandidateBean> lst = (List<CandidateBean>)criteria.list();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public void saveCandidate(CandidateBean candidateBean) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(candidateBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateCandidate(CandidateBean candidateBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			  CandidateBean existingPerson = (CandidateBean) session.get(CandidateBean.class, candidateBean.getId());
			  candidateBean.setRounds(existingPerson.getRounds());
			  BeanUtils.copyProperties(existingPerson, candidateBean);
			  session.save(existingPerson);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	

	

}
